package com.heu.his.controller;

import com.heu.his.Iservice.ISexchService;
import com.heu.his.pojo.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/sexch")
public class SexchController {
    
    @Autowired
    ISexchService sexchService;

    @RequestMapping("/list")
    public java.util.List<Sex> list(){return sexchService.getsexnamelist();}
}
