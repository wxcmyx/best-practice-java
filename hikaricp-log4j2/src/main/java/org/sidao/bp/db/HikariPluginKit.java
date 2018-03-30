package org.sidao.bp.db;

import com.jfinal.core.Const;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class HikariPluginKit {
	private static Prop dbProp = PropKit.use("dbconfig.properties",Const.DEFAULT_ENCODING);
	
    public static HikariCpPlugin createHikariPlugin(){
		// 配置Hikaricp数据库连接池插件
    	HikariCpPlugin hikariPlugin = new HikariCpPlugin(dbProp.get("jdbc.url"), dbProp.get("jdbc.username"), 
    			dbProp.get("jdbc.password").trim(),dbProp.get("jdbc.driverProxyClassName"),dbProp.get("jdbc.driver"));
//    	hikariPlugin.setInitialSize(dbProp.getInt("jdbc.initialSize",1));
    	hikariPlugin.setMaximumPoolSize(dbProp.getInt("jdbc.maxActive",2));
    	hikariPlugin.setIdleTimeout(dbProp.getInt("jdbc.maxWait",60000));
    	hikariPlugin.setMaxLifetime(dbProp.getInt("jdbc.minEvictableIdleTimeMillis",120000));
		return hikariPlugin;
    }
    public static HikariCpPlugin createHikariPluginUseFile(){
		// 配置Hikaricp数据库连接池插件
    	HikariCpPlugin hikariPlugin = new HikariCpPlugin("dbconfig.properties","hikari.properties",false);
		return hikariPlugin;
    }
}
