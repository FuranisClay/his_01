package com.heu.his.service;

import com.heu.his.Iservice.ISysMenuzgyService;
import com.heu.his.mapper.SysMenuzgyMapper;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-25 15:57
 */
@Service
public class SysMenuzgyService implements ISysMenuzgyService {

    @Autowired
    SysMenuzgyMapper sysMenuzgyMapper;

    @Override
    public List<SysMenu> getSysMenuList(int rid) {
        return sysMenuzgyMapper.getSysMenuList(rid);
    }
}
