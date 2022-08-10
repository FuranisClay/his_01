package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IUserchService;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserchController {

    @Autowired
    IUserchService userchService;

    @RequestMapping("/validate")
    public User validate(String rn,String pw){
//        System.out.println(rn+"------");
//        System.out.println(pw+"------");
        return userchService.validate(rn,pw);
    }
    
    @RequestMapping("/list")
    public java.util.List<User> list(int Did,int rid){return userchService.getdeptusername(Did,rid);}
}
