package com.heu.his.controller;

import com.heu.his.Iservice.IUserzgyService;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-22 10:43
 */
@CrossOrigin
@RestController
@RequestMapping("/userzgy")
public class UserzgyController {

    @Autowired
    IUserzgyService userService;

    @RequestMapping("/add")
    public int addDept(User user){
        System.out.println(user.toString());
        return userService.insertUser(user);
    }

    @RequestMapping("/maxid")
    public int getMaxID(){
        return userService.getUserMaxID();
    }

    @RequestMapping("/delete")
    public int deleteUser(int id){
        return userService.deleteUserById(id);
    }

    @RequestMapping("/update")
    public int updateRegist(User user){
        System.out.println(user.toString());
        return userService.updateUserById(user);
    }

    @RequestMapping("/list")
    public List list(String name) {
        System.out.println("name:"+name);
        return userService.getUserList(name);
    }

    @RequestMapping("/validate")
    public User validate(String ename, String pwd) {
//        System.out.println(ename + "<<<<<");
//        System.out.println(pwd + "<<<<<");
        return userService.validate(ename, pwd);
    }

}
