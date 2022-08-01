package com.heu.his.mapper;

import com.heu.his.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询用户
     * @param rn 用户姓名
     * @param pwd 登录密码
     * @return
     */
    @Select("select * from user where UserName=#{rn} and Password=#{pwd}")
    User validate(@Param(value = "rn") String rn,@Param(value = "pwd") String pwd);

    @Select("<script>select * from user where 1=1" +
            "<if test=\"name!=null and name != ''\">and UserName=#{name}</if>" +
            "<if test=\"id>0\">and ID=#{id}</if>" +
            "</script>")
    List<User> getUserList(String name, Integer id);


}
