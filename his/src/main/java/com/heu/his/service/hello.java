package com.heu.his.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author legend
 * @create 2022-07-21-15:23
 */
@Controller
@RequestMapping("/hello")

public class hello {
    @ResponseBody
    @RequestMapping("/show")
    public String show(){
        return "欢迎使用springboot";
    }
    @ResponseBody
    @RequestMapping("/wc")
    public String welcome(){
        return "欢迎";
    }
}