package org.sidao.springboot.service;

import org.sidao.springboot.domain.Githubproject;
import org.sidao.springboot.mapper.GithubprojectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GithubprojectService {

    @Autowired
    private GithubprojectMapper githubprojectMapper;
    /**
     * 获取日期对应的项目
     * @param date
     * @return
     */
    public List<org.sidao.jfinal.model.Githubproject> getGpsByDate(Date date){
        return org.sidao.jfinal.model.Githubproject.dao.use("ds1").findByCache("User","pachong_"+date,"select * from githubproject a where a.UPDATE = ?",new Object[]{date});
    }

    /**
     * 获取所有
     * @return
     */
    public List<Githubproject> findAll(){
        return githubprojectMapper.findAll();
    }
}
