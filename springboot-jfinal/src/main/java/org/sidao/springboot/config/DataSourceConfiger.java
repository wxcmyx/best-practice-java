package org.sidao.springboot.config;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.zaxxer.hikari.HikariDataSource;
import org.sidao.jfinal.model._MappingKit;
import org.sidao.jfinal.model._MappingKit2;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置多个HikariCP连接池配置，配置到jfinal使用的链接当中
 */
@Configuration
public class DataSourceConfiger {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ds1")
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSource firstDataSource() {
        HikariDataSource ds= (HikariDataSource) firstDataSourceProperties().initializeDataSourceBuilder().build();
        return ds;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSource secondDataSource() {
        HikariDataSource ds= (HikariDataSource) secondDataSourceProperties().initializeDataSourceBuilder().build();
        return ds;
    }
    @Bean
    @DependsOn("ds1")
    public ActiveRecordPlugin activeFirstDatasource() {
        DataSource ds=firstDataSource();
        ActiveRecordPlugin plugin = new ActiveRecordPlugin("ds1",ds);
        _MappingKit.mapping(plugin);
        plugin.start();
        new EhCachePlugin().start();//启动ehcache
        return plugin;
    }
    @Bean
    @DependsOn("ds2")
    public ActiveRecordPlugin activeSecordDatasource() {
        ActiveRecordPlugin plugin = new ActiveRecordPlugin("ds2",secondDataSource());
        _MappingKit2.mapping(plugin);
        plugin.start();
        return plugin;
    }

}
