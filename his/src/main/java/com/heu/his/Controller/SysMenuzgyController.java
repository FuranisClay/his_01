package com.heu.his.Controller;

import com.heu.his.Iservice.ISysMenuzgyService;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-25 15:58
 */
@CrossOrigin
@RestController
@RequestMapping("/sysmenuzgy")
public class SysMenuzgyController {

    @Autowired
    ISysMenuzgyService iSysMenuService;

    @RequestMapping("/list")
    public List<SysMenu> list(int rid){
        return iSysMenuService.getSysMenuList(rid);
    }

}
