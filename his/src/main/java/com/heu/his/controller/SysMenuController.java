package com.heu.his.controller;

import com.heu.his.Iservice.ISystemMenuService;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/sysmenudzh")
public class SysMenuController {

    @Autowired
    ISystemMenuService systemMenuService;

    @RequestMapping("/list")
    public java.util.List<SysMenu> list(int rid){
        return systemMenuService.getSysMenuList(rid);
    }
}
