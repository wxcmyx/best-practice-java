package org.sidao.springboot.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * HikariCP连接池配置
 */
@Configuration
public class DataSourceConfig {

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
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin("ds1",ds);
//        _MappingKit.mapping(plugin);
//        plugin.start();
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
        try {
            System.out.println("flag------>" + ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin("ds2",ds);
//        _MappingKit2.mapping(plugin);
//        plugin.start();

        return ds;
    }

}
