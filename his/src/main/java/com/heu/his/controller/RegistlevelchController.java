package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IRegistlevelchService;
import com.heu.his.pojo.Registlevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/registlevelch")
public class RegistlevelchController {

    @Autowired
    IRegistlevelchService registlevelchService;

    @RequestMapping("/list")
    public java.util.List<Registlevel> list(){return registlevelchService.getRegistlevelname();}
}
