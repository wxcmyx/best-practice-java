package org.sidao.bp;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
	
	@BeforeMethod
	public void setUp() {
		TestUtils.initDb();
	}

	@Test
	public void countProjects() {
		App app = new App();
		Assert.assertEquals(0, app.countProjects());
	}
}
