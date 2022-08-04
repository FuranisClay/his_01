package com.heu.his.service;

import com.heu.his.Iservice.IDrugsCqService;
import com.heu.his.mapper.DrugsCqMapper;
import com.heu.his.pojo.Constantitem;
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
public class DrugsCqService implements IDrugsCqService {
    @Autowired
    DrugsCqMapper drugsCqMapper;

    public List<Drugs> getDrugsList(@Param("drugsName") String drugsName, @Param("id") int id){
        return drugsCqMapper.getDrugsList(drugsName,id);
    }

    public int deleteById(int id){
        return drugsCqMapper.deleteById(id);
    }
    public int insertDrugs(Drugs drugs){
        return drugsCqMapper.insertDrugs(drugs);
    }
    public List<Constantitem> getConstantitemById(){
        return drugsCqMapper.getConstantitemById();
    };
    public boolean updateById(Drugs drugs){
        return drugsCqMapper.updateById(drugs);
    };
}
