package com.heu.his.service;

import com.heu.his.mapper.CheckApplyMapper;
import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author legend
 * @create 2022-07-31-15:04
 */
@Service
public class CheckApplyService {
    @Autowired
    CheckApplyMapper checkApplyMapper;

    public List<Checkapply> getcheckBycasenum(int rid) {
        return checkApplyMapper.getcheckBycasenum(rid);
    }

    public List<Checkapply> getDrugsList(@Param("name") String name, @Param("id") int id){
        return checkApplyMapper.getDrugsList(name,id);
    }

    public int deleteById(int id){
        return checkApplyMapper.deleteById(id);
    }
    public int insertDrugs(Checkapply checkapply){
        return checkApplyMapper.insertDrugs(checkapply);
    }
    public java.util.List<Disecategory> getConstantitemById(){
        return checkApplyMapper.getConstantitemById();
    };
    public boolean updateById(Checkapply checkapply){
        return checkApplyMapper.updateById(checkapply);
    };
}
