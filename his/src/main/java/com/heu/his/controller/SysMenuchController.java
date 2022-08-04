package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.ISystemMenuchService;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/sysmenu")
public class SysMenuchController {

    @Autowired
    ISystemMenuchService systemMenuService;

    @RequestMapping("/list")
    public java.util.List<SysMenu> list(int rid){
        return systemMenuService.getSysMenuList(rid);
    }
}
