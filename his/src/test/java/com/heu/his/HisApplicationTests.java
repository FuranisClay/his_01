package com.heu.his;

import com.heu.his.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HisApplicationTests {

    @Autowired
    UserchMapper userchMapper;

    @Autowired
    RegisterchMapper registerchMapper;

    @Autowired
    RegistlevelchMapper registlevelchMapper;

    @Autowired
    SysMenuchMapper sysMenuchMapper;

    @Autowired
    PatientcostschMapper patientcostschMapper;

    @Autowired
    DepartmentchMapper departmentchMapper;

    @Autowired
    SettlecategoryChMapper settlecategoryChMapper;

    @Test
    void contextLoads() {

//        registerchMapper.updatereg();

//        settlecategoryChMapper.getsettlecategoryname();

//        registlevelMapper.getRegistlevelname();

//        departmentMapper.getdeptname();

//        userMapper.getdeptusername(1);

//        registerchMapper.getRegisterListAndRL("李白",0,0);
//        patientcostsMapper.getPatientcostsList(35);

//        registerMapper.getRegistcostList("马路");

//        sysMenuchMapper.getSysMenuList(1);

//        一对多查询
//        Registlevel registlevel = registlevelMapper.getRegistlevelById(1);
//        System.out.println(registlevel.getEmps().size());

//        多对一查询
//        registerMapper.getRegisterListAndRL();

//      查询代码测试
//        java.util.List<User> list=userMapper.getUserList();
//        for(User e:list){
//            System.out.println(e);
//        }
//        模糊查询测试
//        registerMapper.getRegisterList("李",1);
    }

}
