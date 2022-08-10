package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RegisterchMapper {


    /**
     * 退号
     * @param cn
     * @return
     */
    @Delete("delete from register where CaseNumber=#{cn}")
    int delregist(int cn);

    /**
     * 挂号添加
     * @param register；挂号数据
     * @return
     */
    @Insert("insert into  register(RealName,CaseNumber, Gender, IDnumber, " +
            "BirthDate, Age, AgeType, PhoneNumber, HomeAddress, VisitDate, Noon,  " +
            "RegistTime, DeptID, RegistLeID, UserID, SettleID, RegisterID, VisitState) " +
            "values (#{realName},#{caseNumber}, #{gender}, #{iDnumber}, #{birthDate}, #{age}, " +
            "#{ageType}, #{phoneNumber}, #{homeAddress}, #{visitDate}, #{noon}, #{registTime}, " +
            "#{deptId}, #{registLeId}, #{userId}, #{settleId},  #{registerId}, #{visitState});")
    int addRegist(Register register);


    /**
     * 患者信息修改
     * @param register：修改信息
     * @return
     */
    @Update("update register set RealName=#{realName},Gender=#{gender},PhoneNumber=#{phoneNumber},HomeAddress=#{homeAddress},SettleID=#{settleId} " +
            "where CaseNumber=#{caseNumber};")
    int updatereg(Register register);

    /**
     * author:Hulake
     * @param rn:患者姓名
     * @return 患者花费
     */
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "patientcosts",column = "ID",many = @Many(select = "com.heu.his.mapper.PatientcostschMapper.getPatientcostsList"))
    })
    @Select("<script>select * from register where 1=1 " +
            "<if test=\"rn!=null and rn!=''\">and RealName like concat('%',#{rn},'%')</if>" +
            "</script>")
    Register getRegistcostList(@Param(value = "rn") String rn);

    /**
     * author:Hulake
     * 查询患者挂号后信息
     * @param rn：患者姓名
     * @param cn：患者病历号
     * @param uid：患者身份证号
     * @return 患者的信息
     */
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "registlevel",column = "RegistLeID",
                    one = @One(select = "com.heu.his.mapper.RegistlevelchMapper.getRegistlevelByIdOne")),
            @Result(property = "user", column = "UserID",
                    one = @One(select = "com.heu.his.mapper.UserchMapper.getUsername")),
            @Result(property = "sex",column = "Gender",one = @One(select = "com.heu.his.mapper.SexchMapper.getsexname")),
            @Result(property = "departments",column = "DeptID", one = @One(select = "com.heu.his.mapper.DepartmentchMapper.getdeptname")),
            @Result(property = "settlecategory",column = "SettleID",one = @One(select = "com.heu.his.mapper.SettlecategoryChMapper.getsettlecategoryid"))
    })
    @Select("<script>select * from register where 1=1 " +
            "<if test=\"rn!=null and rn!=''\">and RealName like concat('%',#{rn},'%')</if>" +
            "<if test=\"cn!=null and cn!=0\">and CaseNumber=#{cn}</if>" +
            "<if test=\"uid!=null and uid!=0\">and IDnumber=#{uid}</if>" +
            "</script>")
    java.util.List<Register> getRegisterListAndRL(
            @Param(value = "rn") String rn, @Param(value = "cn") int cn,@Param(value = "uid") String uid);

    /**
     * 一对多  根据挂号编号查询改编号下的多有患者
     * @param ReLeId 挂号类型编号
     * @return 返回某个类型下的所有患者
     */
    @Select("select * from register where RegistLeID=#{ReLeId}")
    java.util.List<Register> getRegistListByRL(int ReLeId);

    /**
     * 多对一  查询挂号患者的挂号编号
     * @param rn  患者姓名
     * @param rli  患者编号
     * @return
     */
    @Select("<script>select * from register where 1=1 " +
            "<if test=\"rn!=null and rn!=''\">and RealName like concat('%',#{rn},'%')</if>" +
            "<if test=\"rli>0\">and RegistLeID=#{rli}</if>" +
            "</script>")
    java.util.List<Register> getRegisterList(
            @Param(value = "rn") String rn, @Param(value = "rli") int rli);
}
