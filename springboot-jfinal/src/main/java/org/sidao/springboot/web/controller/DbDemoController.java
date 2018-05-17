package org.sidao.springboot.web.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.sidao.springboot.web.rest.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags="GIT项目管理")
@RestController
@EnableAutoConfiguration
public class DbDemoController {

    @Autowired
    private JdbcTemplate db;

    @ApiOperation("获取项目总数")
    @GetMapping("/api/hello")
    @ResponseBody
    public Object home(@ApiParam("查看第几页") @RequestParam int pageIndex,
                       @ApiParam("每页多少条") @RequestParam int pageSize) {
        Map countMap=  db.queryForMap("select count(*) count from githubproject");
        Record record= Db.use("ds1").findFirst("select count(*) count from githubproject");
        record.set("other",countMap.get("count"));
        Record recordc=Db.use("ds1").findFirstByCache("User","count","select count(*) count from githubproject");
        record.set("recordc",recordc.getInt("count"));
        return new Result().setData(record.getColumns());
    }

}
