package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.ISettlecategoryChService;
import com.heu.his.pojo.Settlecategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/settlrcategorych")
public class SettlecategoryChController {

    @Autowired
    ISettlecategoryChService settlecategoryChService;

    @RequestMapping("/list")
    public java.util.List<Settlecategory> list(){
        return settlecategoryChService.getsettlecategoryname();
    }
}
