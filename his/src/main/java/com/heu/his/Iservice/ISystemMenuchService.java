package com.heu.his.Iservice;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.SysMenu;

public interface ISystemMenuchService {

    java.util.List<SysMenu> getSysMenuList(int rid);
}
