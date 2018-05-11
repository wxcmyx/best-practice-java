package org.sidao.springboot.web.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private JdbcTemplate db;

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        String countstr=  db.queryForList("select count(*) from githubproject").toString();
        List<Record> countlist= Db.use("ds1").find("select count(*) from githubproject");
        return countstr+"!!"+countlist.toString();
    }

}
