package com.heu.his.mapper;

import com.heu.his.pojo.Registlevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 16:59
 */
@Mapper
public interface RegistlevelzgyMapper {

    @Select("<script>select * from registlevel where 1=1 " +
            "and DelMark = 1 " +
            "<if test=\"string!=null and string!= ''\">and RegistCode like concat('%',#{string},'%')</if>" +
            "order by SequenceNo" +
            "</script>")
    List<Registlevel> getRegistlevelList(String string);

    @Update("update registlevel set RegistCode=#{registCode}," +
            "RegistName=#{registName},SequenceNo=#{sequenceNo}," +
            "RegistFee=#{registFee},RegistQuota=#{registQuota} " +
            "where ID=#{id}")
    int updateRegistlevelById(Registlevel registlevel);


    @Update("<script>update user set delmark=1 where id in" +
            "<foreach collection=\"array\" item=\"eno\" open=\"(\" close=\")\" separator=\",\">" +
            "#{eno}</foreach>" +
            "</script>")
    int deletesById(int[] arr);

    @Update("update registlevel set DelMark = 0 where ID=#{id}")
    int deleteRegistlevelById(int id);

    @Select("select ID from registlevel order by ID desc limit 1")
    int getRegistlevelMaxId();

    @Insert("insert into registlevel (ID,RegistCode,RegistName,SequenceNo,RegistFee,RegistQuota,DelMark) " +
            "values (#{id},#{registCode},#{registName},#{sequenceNo},#{registFee},#{registQuota},1)")
    int insertRegistlevel(Registlevel registlevel);

    @Select("select * from registlevel where ID=#{id}")
    Registlevel getRegistlevelById(int id);

}
