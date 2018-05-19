package org.sidao.springboot.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sidao.springboot.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CounryServiceTest {

    @Autowired
    CounryService counryService;


    @Test
    public void testFindAll() throws Exception {

        List<Country> result = counryService.findAll();
        Assert.assertEquals(183, result.size());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
