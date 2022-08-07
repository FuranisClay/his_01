package com.heu.his.Iservice;

import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Disease;

import com.heu.his.pojo.Disecategory;
import org.apache.ibatis.annotations.Param;

public interface IDiseaseService {
    java.util.List<Disease> getDrugsList(@Param("diseaseName") String diseaseName, @Param("id") int id);
    int deleteById(int id);
    int insertDrugs(Disease disease);
    java.util.List<Disecategory> getConstantitemById();
    boolean updateById(Disease disease);
}
