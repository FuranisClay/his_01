package com.heu.his.mapper;

import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.*;

/**
 * @author legend
 * @create 2022-07-31-9:30
 */
@Mapper
public interface RegisterCqMapper {

    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "genderName",column = "gender",one = @One(select = "com.heu.his.mapper.RegisterCqMapper.selectGenderName"))
    })
    @Select("<script>select * from register where 1=1"+
            "<if test=\"caseNumber!=null and caseNumber!=''\">and CaseNumber=#{caseNumber} </if>" +
            "<if test=\"realName!=null and realName!=''\">and RealName=#{realName} </if></script>")
    java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber);

//    @Results({
//            @Result(property = "registId",column = "registId",id = true),
//            @Result(property = "amount",column = "id,registId",one = @One(select = "com.heu.his.mapper.RegisterCqMapper.selectDrugsAmountById"))
//    })
    @Select("select * from drugs where id in (select DrugsID from prescriptiondetailed where PrescriptionID in (select ID from prescription where  RegistID =#{id}))")
    java.util.List<Drugs> selectDrugsByRegisterId(int id);
    @Select("select Amount from prescriptiondetailed where PrescriptionID in (select ID from prescription where RegistID=#{registerId}) and drugsId=#{drugsId}")
    java.util.List<Integer> selectDrugsAmountById(@Param("registerId") Integer registerId, @Param("drugsId") Integer drugsId);
    @Select("select ID from prescriptiondetailed where PrescriptionID in (select ID from prescription where RegistID=#{id})")
    java.util.List<Integer> selectPreIdById(int id);
//    @Results({
//            @Result(property = "registId",column = "registId",id = true),
//            @Result(property = "fmeditems",column = "itemID",many = @Many(select = "com.heu.his.mapper.RegisterCqMapper.getFmeditemById"))
//    })
    @Select("select * from checkapply where RegistID=#{id}")
    java.util.List<Checkapply> selectCheckApplyByRegistId(int id);
    @Update("update checkapply set ResultTime=#{resultTime} where ID=#{id}")
    int setCheckState(Checkapply checkapply);
    @Select("select * from fmeditem where id=#{id}")
    Fmeditem getFmeditemById(int id);
    @Update("Update prescriptiondetailed set state=#{state} where ID=#{id}")
    int setDrugsState(@Param("id") int id, @Param("state") int state);

    @Select("select * from prescriptiondetailed where PrescriptionID in (select ID from prescription where RegistID=#{id})")
    java.util.List<Prescriptiondetailed> selectPreById(int id);

    @Insert("insert into prescriptiondetailed(PrescriptionID,DrugsID,DrugsUsage,Dosage,Frequency,Amount,State)" +
            " values(#{prescriptionId},#{drugsId},#{drugsUsage},#{dosage},#{frequency},#{amount},#{state}) ")
    int insertPre(Prescriptiondetailed prescriptiondetailed);
    @Insert("insert into medicalrecord(CaseNumber,RegistID,Readme,Present,PresentTreat,History,Allergy,Physique" +
            ",Proposal,Careful,CheckResult,Diagnosis,Handling,CaseState) values(#{caseNumber},#{registId},#{readme}," +
            "#{present},#{presentTreat},#{history},#{allergy},#{physique},#{proposal},#{careful},#{checkResult},#{diagnosis},#{handling},#{caseState})")
    int insertMedical(Medicalrecord medicalrecord);
    @Insert("insert into prescription(MedicalID,RegistID,UserID,PrescriptionName,PrescriptionTime,PrescriptionState" +
            ") values(#{medicalId},#{registId},#{userId},#{prescriptionName},#{prescriptionTime},#{prescriptionState})")
    int insertPr(Prescription prescription);
    @Select("select * from medicalrecord")
    java.util.List<Medicalrecord> selectAllM();
    @Select("select * from prescriptiondetailed")
    java.util.List<Prescriptiondetailed> selectAllP();
    @Select("select * from prescription where RegistID = #{id}")
    java.util.List<Prescription> selectByRID(int id);
    @Select("select ConstantName from constantitem where id=#{id}")
    String selectGenderName(int id);
    @Insert("insert into patientcosts(RegistID,InvoiceID,ItemID,ItemType,Name,Price,Amount,DeptID,Createtime,CreateOperId,PayTime,RegisterID,FeeType)" +
            " values(#{registId},#{invoiceId},#{itemId},#{itemType},#{name},#{price},#{amount},#{deptId}" +
            ",#{createtime},#{createOperId},#{payTime},#{registerId},#{feeType})")
    int insertPatientCost(Patientcosts patientcosts);
    @Insert("insert into checkapply(MedicalID,RegistID,ItemID,Name,CreationTime,CheckOperID,ResultOperID,RecordType,ResultTime) values(" +
            "#{medicalId},#{registId},#{itemId},#{name},#{creationTime},#{checkOperId},#{resultOperId},#{recordType},#{resultTime})")
    int insertCheckApply(Checkapply checkapply);
    @Select("select * from medicalrecord where RegistID=#{id}")
    java.util.List<Medicalrecord> selectM(int id);


}
