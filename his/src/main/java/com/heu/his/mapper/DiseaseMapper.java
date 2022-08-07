package com.heu.his.mapper;

import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Disease;

import com.heu.his.pojo.Disecategory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DiseaseMapper {
    @Select("<script>select * from disease where 1=1" +
            "<if test=\"diseaseName!=null and diseaseName!=''\">and DiseaseName like concat('%',#{diseaseName},'%') </if>" +
            "<if test=\"id>0\">and ID=#{id}</if></script>")
    java.util.List<Disease> getDrugsList(@Param("diseaseName") String diseaseName, @Param("id") int id);

    @Insert("insert into disease(ID,CaseNumber,DiseaseName,DiseCategoryID,Advice,DiseaseICD," +
            "DelMark) values(#{id},#{caseNumber},#{diseaseName},#{diseCategoryID},#{advice},#{diseaseICD}," +
            "#{delMark})")
    int insertDrugs(Disease disease);

    @Delete("delete from disease where id=#{ID}")
    int deleteById(int id);
    @Update("<script>update disease set DelMark=0 where id in" +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\">" +
            "#{id}</foreach>" +
            "</script>")
    int updateDelmark(int[] arr);
    //    @Update("update drugs   ")
    @Select("select * from disecategory where id >= 1")
    java.util.List<Disecategory> getConstantitemById();

    @Update("update disease set CaseNumber=#{caseNumber},DiseaseName=#{diseaseName},DiseCategoryID=#{diseCategoryID},Advice=#{advice}" +
            ",DiseaseICD=#{diseaseICD}," +
            "" +
            "where ID=#{id}")
    boolean updateById(Disease disease);
}
