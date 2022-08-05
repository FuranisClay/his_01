package com.heu.his.Iservice;

import com.heu.his.pojo.Department;
import com.heu.his.pojo.Registlevel;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-26 16:03
 */
public interface IDepartmentService {

    List<Department> getDepartmentList(String string);

    int getDepartmentMaxID();

    int insertDepartment(Department department);

    int deleteDepartmentById(int id);

}
