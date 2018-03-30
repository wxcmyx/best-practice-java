package org.sidao.bp;


import org.sidao.bp.db.HikariCpPlugin;
import org.sidao.bp.db.HikariPluginKit;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;

/**
 * @author wxc
 *
 */
public class TestUtils {
	public static void initDb(){
		//hikari数据库连接池
		HikariCpPlugin hikarPlugin=HikariPluginKit.createHikariPluginUseFile();
		hikarPlugin.start();
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(hikarPlugin);
		arp.setTransactionLevel(4);
		arp.setDialect(new MysqlDialect());
		arp.setShowSql(false);
		arp.start();
	}
}
