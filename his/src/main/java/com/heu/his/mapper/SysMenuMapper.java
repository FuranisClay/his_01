package com.heu.his.mapper;

import com.heu.his.pojo.SysMenu;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysMenuMapper {


//    根据登录的用户信息，查询改用户对应的权限
    @Results({
            @Result(property = "menuId",column = "menu_id",id = true),
            @Result(property = "childMenu",column = "menu_id",many = @Many(select = "com.heu.his.mapper.SysMenuMapper.getChildMenuList"))
    })
    @Select("select * from sys_menu where menu_id in(" +
            "select menu_id from sys_role_menu where role_id=#{rid});")
    java.util.List<SysMenu> getSysMenuList(int rid);

    //根据父及权限编号，查询该权限下的自己权限
    @Select("select * from sys_menu where parent_id=#{pid}")
    java.util.List<SysMenu> getChildMenuList(int pid);
}
