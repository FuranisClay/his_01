package com.heu.his.Iservice;

import com.heu.his.pojo.SysMenu;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-25 15:57
 */
public interface ISysMenuzgyService {

    List<SysMenu> getSysMenuList(int rid);

}
