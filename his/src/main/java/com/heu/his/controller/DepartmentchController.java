package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IDepartmentchService;
import com.heu.his.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@CrossOrigin
@RequestMapping("/departmentch")
public class DepartmentchController {

    @Autowired
    IDepartmentchService departmentchService;

    @RequestMapping("/list")
    public java.util.List<Department> list(){return departmentchService.getdepartment();}

}
