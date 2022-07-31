package com.heu.his.service;

import com.heu.his.Iservice.ISystemMenuService;
import com.heu.his.mapper.SysMenuMapper;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService implements ISystemMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    public List<SysMenu> getSysMenuList(int rid) {
        return sysMenuMapper.getSysMenuList(rid);
    }
}
