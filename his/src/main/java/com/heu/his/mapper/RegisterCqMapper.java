package com.heu.his.mapper;

import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Drugs;
import com.heu.his.pojo.Fmeditem;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author legend
 * @create 2022-07-31-9:30
 */
@Mapper
public interface RegisterCqMapper {
    @Select("<script>select * from register where 1=1"+
            "<if test=\"caseNumber!=null and caseNumber!=''\">and CaseNumber=#{caseNumber} </if>" +
            "<if test=\"realName!=null and realName!=''\">and RealName=#{realName} </if></script>")
    java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber);

    @Select("select * from drugs where id in (select DrugsID from prescriptiondetailed where PrescriptionID in (select ID from prescription where  RegistID =#{id}))")
    java.util.List<Drugs> selectDrugsByRegisterId(int id);
    @Select("select Amount from prescriptiondetailed where PrescriptionID in (select ID from prescription where RegistID=#{id})")
    java.util.List<Integer> selectDrugsAmountById(int id);

    @Results({
            @Result(property = "registId",column = "registId",id = true),
            @Result(property = "fmeditems",column = "itemID",many = @Many(select = "com.heu.his.mapper.RegisterCqMapper.getFmeditemById"))
    })
    @Select("select * from checkapply where RegistID=#{id}")
    java.util.List<Checkapply> selectCheckApplyByRegistId(int id);
    @Select("select * from fmeditem where id=#{id}")
    Fmeditem getFmeditemById(int id);
}
