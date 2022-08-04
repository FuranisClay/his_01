package com.heu.his.service;

import com.heu.his.Iservice.IDepartmentzgyService;
import com.heu.his.mapper.DepartmentzgyMapper;
import com.heu.his.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-26 16:04
 */
@Service
public class DepartmentzgyService implements IDepartmentzgyService {

    @Autowired
    DepartmentzgyMapper departmentzgyMapper;

    @Override
    public int deleteDepartmentById(int id) {
        return departmentzgyMapper.deleteDepartmentById(id);
    }

    @Override
    public int updateDepartmentById(Department department) {
        return departmentzgyMapper.updateDepartmentById(department);
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentzgyMapper.insertDepartment(department);
    }

    @Override
    public int getDepartmentMaxID() {
        return departmentzgyMapper.getDepartmentMaxID();
    }

    @Override
    public List<Department> getDepartmentList(String string) {
        return departmentzgyMapper.getDepartmentList(string);
    }
}
