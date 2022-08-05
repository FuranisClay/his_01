package com.heu.his.mapper;

import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:17
 */
@Mapper
public interface SchedulingMapper {

    @Results({
            @Result(property = "id",column = "ID",id = true),
            @Result(property = "deptId",column = "DeptID"),
            @Result(property = "department",column = "DeptID",one = @One(select = "com.heu.his.mapper.DepartmentMapper.getDepartmentById")),
            @Result(property = "userId", column = "UserID"),
            @Result(property = "user", column = "UserID", one = @One(select = "com.heu.his.mapper.UserMapper.getUserByID"))
    })
    @Select("select * from scheduling")
    List<Scheduling> getSchedulingList();

}
