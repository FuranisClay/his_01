package com.heu.his.controller;

import com.heu.his.Iservice.IDepartmentService;
import com.heu.his.pojo.Department;
import com.heu.his.pojo.Registlevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-26 16:05
 */
@RestController
@CrossOrigin
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @RequestMapping("/update")
    public int updateRegist(Department department){
        System.out.println(department.toString());
        return 1;
    }

    @RequestMapping("/delete")
    public int deleteDepartment(int id){
        return departmentService.deleteDepartmentById(id);
    }

    @RequestMapping("/add")
    public int addDept(Department department){
        System.out.println(department.toString());
        return departmentService.insertDepartment(department);
//        return departmentService.insertRegistlevel(registlevel);
    }

    @RequestMapping("/list")
    public List<Department> list(String string){
        return departmentService.getDepartmentList(string);
    }

    @RequestMapping("/maxid")
    public int getMaxID(){
        return departmentService.getDepartmentMaxID();
    }

}
