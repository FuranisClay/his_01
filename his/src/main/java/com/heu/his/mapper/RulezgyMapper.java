package com.heu.his.mapper;

import com.heu.his.pojo.Department;
import com.heu.his.pojo.Rule;
import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-05 10:02
 */
@Mapper
public interface RulezgyMapper {

    @Results({
            @Result(property = "id",column = "ID",id = true),
            @Result(property = "deptId",column = "DeptID"),
            @Result(property = "department",column = "DeptID",one = @One(select = "com.heu.his.mapper.DepartmentzgyMapper.getDepartmentById")),
            @Result(property = "userId", column = "UserID"),
            @Result(property = "user", column = "UserID", one = @One(select = "com.heu.his.mapper.UserzgyMapper.getUserByID"))
    })
    @Select("<script>select * from rule where 1=1 and DelMark=1 " +
            "<if test=\"deptno>0\">and DeptID=#{deptno}</if>" +
            "</script>")
    List<Rule> getRuleList(int deptno);

    @Update("<script>update rule set delmark=0 where ID in" +
            "<foreach collection=\"array\" item=\"eno\" open=\"(\" close=\")\" separator=\",\">" +
            "#{eno}</foreach>" +
            "</script>")
    int deletesById(int[] arr);

    @Select("select ID from rule order by ID desc limit 1")
    int getRuleMaxID();

    @Insert("insert into rule (ID,RuleName,DeptID,UserID,Week,DelMark) " +
            "values (#{id},#{ruleName},#{deptid},#{userid},#{week},1)")
    int insertRule(@Param("id") int id,@Param("ruleName") String ruleName,@Param("deptid") int deptid,@Param("userid") int userid,@Param("week") String week);


}
