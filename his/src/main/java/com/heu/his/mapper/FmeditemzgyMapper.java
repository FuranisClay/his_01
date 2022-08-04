package com.heu.his.mapper;

import com.heu.his.pojo.Fmeditem;
import com.heu.his.pojo.Registlevel;
import com.heu.his.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:00
 */
@Mapper
public interface FmeditemzgyMapper {

    @Results({
            @Result(property = "id",column = "ID",id = true),
            @Result(property = "expClassId",column = "ExpClassID"),
            @Result(property = "expenseclass",column = "ExpClassID",one = @One(select = "com.heu.his.mapper.ExpenseclasszgyMapper.getExpenseclassByID")),
            @Result(property = "deptId", column = "DeptID"),
            @Result(property = "department", column = "DeptID", one = @One(select = "com.heu.his.mapper.DepartmentzgyMapper.getDepartmentById"))
    })
    @Select("<script>select * from fmeditem where 1=1" +
            " and DelMark=1" +
            "<if test=\"string!=null and string!= ''\">and MnemonicCode like concat('%',#{string},'%')</if>" +
            "</script>")
    List<Fmeditem> getFmeditemList(String string);


    @Select("select ID from fmeditem order by ID desc limit 1")
    int getFmeditemMaxId();

    @Update("update fmeditem set DelMark = 0 where ID=#{id}")
    int deleteFmeditemById(int id);

    @Update("update fmeditem set ItemName=#{itemName}," +
            "MnemonicCode=#{mnemonicCode},Format=#{format}," +
            "Price=#{price},ExpClassID=#{expClassId},DeptID=#{deptId}," +
            "LastUpdateDate=#{lastUpdateDate},RecordType=#{recordType} " +
            "where ID=#{id}")
    int updateFmeditemById(Fmeditem fmeditem);

    @Insert("insert into fmeditem (ID,ItemCode,ItemName,Format,Price," +
            "ExpClassID,DeptID,MnemonicCode,CreationDate,RecordType,DelMark) " +
            "values (#{id},#{itemCode},#{itemName},#{format},#{price}," +
            "#{expClassId},#{deptId},#{mnemonicCode},#{creationDate},#{recordType}" +
            ",1)")
    int insertFmeditem(Fmeditem fmeditem);

}
