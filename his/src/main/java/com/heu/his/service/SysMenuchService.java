package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.ISystemMenuchService;
import com.heu.his.mapper.SysMenuchMapper;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuchService implements ISystemMenuchService {

    @Autowired
    SysMenuchMapper sysMenuMapper;

    public List<SysMenu> getSysMenuList(int rid) {
        return sysMenuMapper.getSysMenuList(rid);
    }
}
