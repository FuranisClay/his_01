package com.heu.his;

import com.heu.his.mapper.RegisterMapper;
import com.heu.his.mapper.RegistlevelMapper;
import com.heu.his.mapper.SysMenuMapper;
import com.heu.his.mapper.UserMapper;
import com.heu.his.pojo.Register;
import com.heu.his.pojo.Registlevel;
import com.heu.his.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    RegistlevelMapper registlevelMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Test
    void contextLoads() {

        sysMenuMapper.getSysMenuList(1);

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
        registerMapper.getRegisterList("李",1);
    }

}
