package com.heu.his.controller;

import com.heu.his.Iservice.IRulezgyService;
import com.heu.his.pojo.Rule;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-05 10:02
 */
@CrossOrigin
@RestController
@RequestMapping("/rulezgy")
public class RulezgyController {

    @Autowired
    IRulezgyService rulezgyService;

    @RequestMapping("/addrule")
    public int addrule(String name, int deptid, int userid, boolean[] rule,int num) {
        System.out.println(name);
        System.out.println(deptid);
        System.out.println(userid);
//        System.out.println(Arrays.toString(rule));
        String string = "";
        for (int i = 0; i < rule.length; i++) {
            if (rule[i])
                string += "1";
            else
                string += "0";
        }
        System.out.println(string);
        int id = rulezgyService.getRuleMaxID() + 1 + num;
        return rulezgyService.insertRule(id, name, deptid, userid, string);
    }

//    @RequestMapping("/addrule")
//    public int addrule(String name, List<User> list){
//        System.out.println(name);
//        System.out.println(list);
//        return 1;
//    }

    @RequestMapping("/list")
    public List<Rule> list(int deptno) {
        return rulezgyService.getRuleList(deptno);
    }

    @RequestMapping("/delete")
    public int delete(int[] list) {
        System.out.println(list.toString());
        System.out.println(list.length);
        int i;
        for (i = 0; i < list.length; i++) {
            System.out.println(":" + list[i]);
        }
        return rulezgyService.deletesById(list);
    }

}
