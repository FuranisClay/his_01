package com.heu.his.mapper;

import com.heu.his.pojo.SysMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-25 15:44
 */
@Mapper
public interface SysMenuzgyMapper {

    //根据登陆的信息，查看该员工对应的一级权限
    @Results({
            @Result(property = "menuId", column = "menu_id",id = true),
            @Result(property = "childMenu", column = "menu_id",many = @Many(select = "com.heu.his.mapper.SysMenuzgyMapper.getChildMenuList"))
    })
    @Select("select * from sys_menu where menu_id in" +
            "(select menu_id from sys_role_menu where role_id = #{rid})")
    List<SysMenu> getSysMenuList(int rid);

    //根据父级权限编号，查询该权限下的子集权限
    @Select("select * from sys_menu where parent_id = #{pid}")
    List<SysMenu> getChildMenuList(int pid);

}
