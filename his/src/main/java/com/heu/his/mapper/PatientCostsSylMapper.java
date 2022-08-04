package com.heu.his.mapper;

import com.heu.his.pojo.Patientcosts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientCostsSylMapper {

    @Select("select * from patientcosts where registerid=#{registerid}")
    java.util.List<Patientcosts> selectByRegisterID(String registerid);
}
