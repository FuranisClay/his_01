package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Patientcosts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientcostschMapper {

    /**
     * author:Hulake
     * @param RID:患者编号
     * @return 患者花费
     */
    @Select("select * from patientcosts where 1=1 and RegistID=#{RID};")
    java.util.List<Patientcosts> getPatientcostsList(int RID);
}
