package org.sidao.springboot;

import com.jfinal.kit.PathKit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sidao.jfinal.model.Githubproject;
import org.sidao.springboot.domain.Country;
import org.sidao.springboot.service.CounryService;
import org.sidao.springboot.service.GithubprojectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    CounryService counryService;

    @Autowired
    GithubprojectService githubprojectService;

    private Logger log=LoggerFactory.getLogger(this.getClass());

    @Test
    public void testHome() throws Exception {
        log.info("------>>>>>"+PathKit.getWebRootPath());
    }

    @Test
    public void testFindAll() throws Exception {

        List<Country> result = counryService.findAll();
        Assert.assertEquals(183, result.size());
    }




    @Test
    public void testGetGpsByDate() throws Exception {
        List<Githubproject> result = githubprojectService.getGpsByDate(new Date(new GregorianCalendar(2018, Calendar.MARCH, 22).getTime().getTime()));
        log.info("------>>>>>"+result.size() );
        List<org.sidao.springboot.domain.Githubproject> res=githubprojectService.findAll();
        Assert.assertEquals(349, result.size());
        Assert.assertEquals(396343, res.size());
    }
}
