package com.heu.his.mapper;

import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Disecategory;
import org.apache.ibatis.annotations.*;

/**
 * @author legend
 * @create 2022-07-31-15:03
 */
@Mapper
public interface CheckApplyMapper {
    @Select("select * from checkapply where RegistID=#{rid}")
    java.util.List<Checkapply> getcheckBycasenum(int rid);


    @Select("<script>select * from checkapply where 1=1" +
            "<if test=\"name!=null and name!=''\">and Name like concat('%',#{name},'%') </if>" +
            "<if test=\"id>0\">and ID=#{id}</if></script>")
    java.util.List<Checkapply> getDrugsList(@Param("name") String name, @Param("id") int id);

    @Insert("insert into checkapply(ID,RegistID,Name,Num,Result,State,objective,recordType" +
            "CreationTime,ResultTime,DelMark) values(#{id},#{registId},#{name},#{num},#{result},#{state},#{objective},#{recordType}," +
            "#{creationTime},#{resultTime},#{delMark})")
    int insertDrugs(Checkapply checkapply);

    @Delete("delete from checkapply where id=#{ID}")
    int deleteById(int id);
    @Update("<script>update checkapply set DelMark=0 where id in" +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\">" +
            "#{id}</foreach>" +
            "</script>")
    int updateDelmark(int[] arr);
    //    @Update("update drugs   ")
    @Select("select * from disecategory where id >= 1")
    java.util.List<Disecategory> getConstantitemById();

    @Update("update checkapply set Name=#{name},Num=#{num},Result=#{result},State=#{state}" +
            ",Objective=#{objective},RecordType=#{recordType}," +
            "CreationTime=#{creationTime},ResultTime=#{resultTime}" +
            "where ID=#{id}")
    boolean updateById(Checkapply checkapply);

}
