package com.heu.his.service;

import com.heu.his.Iservice.IDrugsService;
import com.heu.his.mapper.DrugsMapper;
import com.heu.his.pojo.Drugs;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author legend
 * @create 2022-07-30-15:37
 */
@Service
public class DrugsService implements IDrugsService {
    @Autowired
    DrugsMapper drugsMapper;

    public List<Drugs> getDrugsList(@Param("drugsName") String drugsName, @Param("id") int id){
        return drugsMapper.getDrugsList(drugsName,id);
    }

    public int deleteById(int id){
        return drugsMapper.deleteById(id);
    }
    public int insertDrugs(Drugs drugs){
        return drugsMapper.insertDrugs(drugs);
    }
}
