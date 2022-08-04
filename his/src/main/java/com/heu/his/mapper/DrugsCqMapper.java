package com.heu.his.mapper;

import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Drugs;
import org.apache.ibatis.annotations.*;

/**
 * @author legend
 * @create 2022-07-30-15:36
 */
@Mapper
public interface DrugsCqMapper {
    @Select("<script>select * from drugs where 1=1" +
            "<if test=\"drugsName!=null and drugsName!=''\">and DrugsName like concat('%',#{drugsName},'%') </if>" +
            "<if test=\"id>0\">and ID=#{id}</if></script>")
    java.util.List<Drugs> getDrugsList(@Param("drugsName") String drugsName, @Param("id") int id);

    @Insert("insert into drugs(ID,DrugsCode,DrugsName,DrugsFormat,DrugsUnit,Manufacturer,DrugsDosageID,DrugsTypeID,DrugsPrice,MnemonicCode," +
            "CreationDate,LastUpdateDate,DelMark) values(#{id},#{drugsCode},#{drugsName},#{drugsFormat},#{drugsUnit},#{manufacturer},#{drugsDosageId},#{drugsTypeId},#{drugsPrice},#{mnemonicCode}," +
            "#{creationDate},#{lastUpdateDate},#{delMark})")
    int insertDrugs(Drugs drugs);

    @Delete("delete from drugs where id=#{ID}")
    int deleteById(int id);
    @Update("<script>update drugs set DelMark=0 where id in" +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\">" +
            "#{id}</foreach>" +
            "</script>")
    int updateDelmark(int[] arr);
//    @Update("update drugs   ")
    @Select("select * from constantitem where id >= 110")
    java.util.List<Constantitem> getConstantitemById();

    @Update("update drugs set DrugsCode =#{drugsCode},DrugsName=#{drugsName},DrugsFormat=#{drugsFormat},DrugsUnit=#{drugsUnit}" +
            ",Manufacturer=#{manufacturer},DrugsDosageID=#{drugsDosageId},DrugsTypeID=#{drugsTypeId},DrugsPrice=#{drugsPrice},MnemonicCode=#{mnemonicCode}," +
            "CreationDate=#{creationDate},LastUpdateDate=#{lastUpdateDate}" +
            "where ID=#{id}")
    boolean updateById(Drugs drugs);
}
