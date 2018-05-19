package org.sidao.springboot.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sidao.jfinal.model.Githubproject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubprojectServiceTest {

    @Autowired
    GithubprojectService githubprojectService;

    private Logger log=LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetGpsByDate() throws Exception {
        List<Githubproject> result = githubprojectService.getGpsByDate(new Date(new GregorianCalendar(2018, Calendar.MARCH, 22).getTime().getTime()));
        log.info("------>>>>>"+result.size() );
        List<org.sidao.springboot.domain.Githubproject> res=githubprojectService.findAll();
        Assert.assertEquals(349, result.size());
        Assert.assertEquals(396343, res.size());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
