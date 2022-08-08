package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.ISexchService;
import com.heu.his.mapper.SexchMapper;
import com.heu.his.pojo.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexchService implements ISexchService {

    @Autowired
    SexchMapper sexchMapper;

    public List<Sex> getsexnamelist() {
        return sexchMapper.getsexnamelist();
    }
}
