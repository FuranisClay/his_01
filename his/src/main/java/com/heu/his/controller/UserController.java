package com.heu.his.controller;

import com.heu.his.Iservice.IUserService;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Userdzh")
public class UserController {

    @Autowired
    IUserService userService;
	
	@RequestMapping("/list")
    public List list(String name, Integer id) {
        return userService.getUserList("", 0);
    }

    @RequestMapping("/validate")
    public User validate(String rn,String pw){
//        System.out.println(rn+"------");
//        System.out.println(pw+"------");
        return userService.validate(rn,pw);
    }
}
