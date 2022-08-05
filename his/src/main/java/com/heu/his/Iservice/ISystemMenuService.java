package com.heu.his.Iservice;

import com.heu.his.pojo.SysMenu;

public interface ISystemMenuService {

    java.util.List<SysMenu> getSysMenuList(int rid);
}
