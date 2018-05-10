package org.sidao.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private JdbcTemplate db;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
//        db.queryForList("select count(*) from githubproject");
        return  db.queryForList("select count(*) from githubproject").toString();
    }

}
