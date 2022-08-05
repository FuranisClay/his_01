package com.heu.his.mapper;

import com.heu.his.pojo.Fmeditem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:00
 */
@Mapper
public interface FmeditemMapper {

    @Results({
            @Result(property = "id",column = "ID",id = true),
            @Result(property = "expClassId",column = "ExpClassID"),
            @Result(property = "expenseclass",column = "ExpClassID",one = @One(select = "com.heu.his.mapper.ExpenseclassMapper.getExpenseclassByID")),
            @Result(property = "deptId", column = "DeptID"),
            @Result(property = "department", column = "DeptID", one = @One(select = "com.heu.his.mapper.DepartmentMapper.getDepartmentById"))
    })
    @Select("<script>select * from fmeditem where 1=1" +
            " and DelMark=1" +
            "<if test=\"string!=null and string!= ''\">and MnemonicCode like concat('%',#{string},'%')</if>" +
            "</script>")
    List<Fmeditem> getFmeditemList();

    @Select("select ID from fmeditem order by ID desc limit 1")
    int getFmeditemMaxId();

    @Delete("delete from fmeditem where ID=#{id}")
    int deleteFmeditemById(int id);

    @Update("update fmeditem set ItemName=#{itemName}," +
            "MnemonicCode=#{mnemonicCode},Format=#{format}," +
            "Price=#{price},ExpClassID=#{expClassId},DeptID=#{deptId},LastUpdateDate=#{lastUpdateDate} " +
            "where ID=#{id}")
    int updateFmeditemById(Fmeditem fmeditem);

}
