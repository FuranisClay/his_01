package com.heu.his.service;

import com.heu.his.Iservice.IDepartmentService;
import com.heu.his.mapper.DepartmentMapper;
import com.heu.his.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-26 16:04
 */
@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int deleteDepartmentById(int id) {
        return departmentMapper.deleteDepartmentById(id);
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public int getDepartmentMaxID() {
        return departmentMapper.getDepartmentMaxID();
    }

    @Override
    public List<Department> getDepartmentList(String string) {
        return departmentMapper.getDepartmentList(string);
    }
}
