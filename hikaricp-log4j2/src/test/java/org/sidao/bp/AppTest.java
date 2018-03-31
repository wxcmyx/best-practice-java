package org.sidao.bp;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sidao.bp.db.SqlBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.hutool.core.date.DateUtil;


public class AppTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(AppTest.class.getName());
	
	@BeforeMethod
	public void setUp() {
		TestUtils.initDb();
	}

	@Test
	public void countProjects() {
		App app = new App();
		Assert.assertEquals(0, app.countProjects());
		SqlBuilder sql=new SqlBuilder().SELECT("name,a.update").FROM("githubproject a").WHERE("a.update=?").addParams(DateUtil.format(new Date(), "yyyy-MM-dd"));
		logger.info("sql:"+sql.buildOneline());
		Record record=Db.findFirst(sql.build(),sql.params());
		
		Assert.assertNotNull(record);
	}
}
