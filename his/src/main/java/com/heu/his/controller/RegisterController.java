package com.heu.his.controller;


import com.heu.his.Iservice.IRegisterService;
import com.heu.his.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    IRegisterService registerService;

    @RequestMapping("/list")
    public java.util.List<Register> list(String rn){
        return registerService.getRegisterListAndRL(rn);
    }
}
