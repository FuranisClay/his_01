package com.heu.his.mapper;

import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:17
 */
@Mapper
public interface SchedulingzgyMapper {

    @Results({
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "deptId", column = "DeptID"),
            @Result(property = "department", column = "DeptID", one = @One(select = "com.heu.his.mapper.DepartmentzgyMapper.getDepartmentById")),
            @Result(property = "userId", column = "UserID"),
            @Result(property = "user", column = "UserID", one = @One(select = "com.heu.his.mapper.UserzgyMapper.getUserByID"))
    })
    @Select("<script>select * from scheduling where 1=1" +
            "<if test=\"startTime!='' and endTime!=''\"" +
            ">and SchedDate between #{startTime} and #{endTime} </if>" +
            "order by SchedDate,ID" +
            "</script>")
    List<Scheduling> getSchedulingList(@Param("startTime") String startTime,@Param("endTime") String endTime);

    @Select("select ID from scheduling order by ID desc limit 1")
    int getSchedulingMaxID();

    @Insert("insert into scheduling (ID,SchedDate,DeptID,UserID,Noon,RuleID,DelMark) " +
            "values (#{id},#{scheddate},#{deptid},#{userid},#{noon},#{ruleid},1)")
    int insertScheduling(int id, Date scheddate, int deptid, int userid, String noon, int ruleid);

}
