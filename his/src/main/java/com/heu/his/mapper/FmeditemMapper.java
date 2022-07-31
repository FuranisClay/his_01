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
    @Select("select * from fmeditem")
    List<Fmeditem> getFmeditemList();

}
