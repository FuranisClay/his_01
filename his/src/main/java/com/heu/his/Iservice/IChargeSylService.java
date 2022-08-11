package com.heu.his.Iservice;

import com.heu.his.pojo.Patientcosts;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;

public interface IChargeSylService {

    java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber);

    java.util.List<Patientcosts> selectById(@Param("id")String id);
}
