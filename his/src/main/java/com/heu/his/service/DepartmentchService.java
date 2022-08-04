package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IDepartmentchService;
import com.heu.his.mapper.DepartmentchMapper;
import com.heu.his.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentchService implements IDepartmentchService {

    @Autowired
    DepartmentchMapper departmentMapper;

    public List<Department> getdepartment() {
        return departmentMapper.getdepartment();
    }
}
