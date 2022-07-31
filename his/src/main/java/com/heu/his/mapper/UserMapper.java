package com.heu.his.mapper;

import com.heu.his.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 查询用户
     * @param rn 用户姓名
     * @param pwd 登录密码
     * @return
     */
    @Select("select * from user where RealName=#{rn} and Password=#{pwd}")
    User validate(@Param(value = "rn") String rn,@Param(value = "pwd") String pwd);
}
