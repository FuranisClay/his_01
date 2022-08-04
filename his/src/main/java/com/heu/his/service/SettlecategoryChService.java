package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.ISettlecategoryChService;
import com.heu.his.mapper.SettlecategoryChMapper;
import com.heu.his.pojo.Settlecategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlecategoryChService implements ISettlecategoryChService {

    @Autowired
    SettlecategoryChMapper settlecategoryChMapper;

    public List<Settlecategory> getsettlecategoryname() {
        return settlecategoryChMapper.getsettlecategoryname();
    }
}
