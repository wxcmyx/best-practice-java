package org.sidao.springboot.service;

import org.sidao.springboot.domain.Country;
import org.sidao.springboot.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounryService {
    @Autowired
    private CountryMapper countryMapper;

    public List<Country> findAll(){
        return countryMapper.findAll();
    }
}
