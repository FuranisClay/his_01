package com.heu.his.service;

import com.heu.his.Iservice.IDiseaseService;
import com.heu.his.mapper.DiseaseMapper;
import com.heu.his.pojo.Constantitem;

import com.heu.his.pojo.Disease;
import com.heu.his.pojo.Disecategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService implements IDiseaseService {
    @Autowired
    DiseaseMapper diseaseMapper;

    public List<Disease> getDrugsList(@Param("diseaseName") String diseaseName, @Param("id") int id){
        return diseaseMapper.getDrugsList(diseaseName,id);
    }

    public int deleteById(int id){
        return diseaseMapper.deleteById(id);
    }
    public int insertDrugs(Disease disease){
        return diseaseMapper.insertDrugs(disease);
    }
    public List<Disecategory> getConstantitemById(){
        return diseaseMapper.getConstantitemById();
    };
    public boolean updateById(Disease disease){
        return diseaseMapper.updateById(disease);
    };
}
