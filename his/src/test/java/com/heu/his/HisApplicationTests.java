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

    @Autowired
    SexchMapper sexchMapper;

    @Autowired
    SchedulingchMapper schedulingchMapper;

    @Autowired
    SchedulingzgyMapper schedulingzgyMapper;
    
    @Test
    void contextLoads() {
        schedulingzgyMapper.getSchedulingList("","");

//        schedulingchMapper.getusernamelist(1,"2022-08-07","上午");

//        registlevelchMapper.getRegistlevelname();

//        sexchMapper.getsexname(72);

//        registerchMapper.updatereg();

//        settlecategoryChMapper.getsettlecategoryname();

//        registlevelMapper.getRegistlevelname();

//        departmentchMapper.getdeptname();

//        userMapper.getdeptusername(1);

//        registerchMapper.getRegisterListAndRL("",600600,'0');
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
