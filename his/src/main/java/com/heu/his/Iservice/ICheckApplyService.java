package com.heu.his.Iservice;

import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.Param;

/**
 * @author legend
 * @create 2022-07-31-15:04
 */
public interface ICheckApplyService {
    java.util.List<Checkapply> getcheckBycasenum(int rid);
    java.util.List<Checkapply> getDrugsList(@Param("name") String name, @Param("id") int id);
    int deleteById(int id);
    int insertDrugs(Checkapply checkapply);
    java.util.List<Disecategory> getConstantitemById();
    boolean updateById(Checkapply checkapply);
}
