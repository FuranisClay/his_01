package com.heu.his.mapper;

import com.heu.his.pojo.Medicalrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author legend
 * @create 2022-07-31-11:26
 */
@Mapper
public interface MedicalRecordMapper {
    @Select("select * from medicalrecord where CaseNumber=#{casenum}")
    java.util.List<Medicalrecord> getMedicalrecordBycasenum(int casenum);

}
