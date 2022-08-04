package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentchMapper {

    /**
     * author:Hulake
     * @return 部门信息
     */
    @Select("select * from department")
    java.util.List<Department> getdepartment();


    /**
     * author:Hulake
     * @param id:部门编号
     * @return
     */
    @Select("select DeptName from department where ID=#{id}")
    java.util.List<Department> getdeptname(int id);
}
