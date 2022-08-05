package com.heu.his.mapper;

import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Department;
import com.heu.his.pojo.Registlevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-22 9:12
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDepartmentById(int id);

    @Results({
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "deptCategoryId", column = "DeptCategoryID"),
            @Result(property = "constantitem", column = "DeptCategoryID", one = @One(select = "com.heu.his.mapper.ConstantItemMapper.getConstantItemByID"))
    })
    @Select("<script>select * from department where 1=1 " +
            "and DelMark = 1 " +
            "<if test=\"string!=null and string!= ''\">and DeptCode like concat('%',#{string},'%')</if>" +
            "</script>")
    List<Department> getDepartmentList(String string);

    @Select("select ID from department where DelMark =1 order by ID desc limit 1")
    int getDepartmentMaxID();

    @Insert("insert into department (ID,DeptCode,DeptName,DeptCategoryID,DeptType,DelMark) " +
            "values (#{id},#{deptCode},#{deptName},#{deptCategoryId},#{deptType},1)")
    int insertDepartment(Department department);

    @Delete("delete from department where ID=#{id}")
    int deleteDepartmentById(int id);

}
