package com.heu.his.mapper;

import com.heu.his.pojo.Patientcosts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientCostsSylMapper {

    @Select("select * from patientcosts where registid=#{registid}")
    java.util.List<Patientcosts> selectById(String id);
}
