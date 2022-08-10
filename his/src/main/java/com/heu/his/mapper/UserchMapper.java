package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserchMapper {


    /**
     * author:Hulake
     * 查询用户
     * @param rn 用户姓名
     * @param pwd 登录密码
     * @return
     */
    @Select("select * from user where UserName=#{rn} and Password=#{pwd}")
    User validate(@Param(value = "rn") String rn,@Param(value = "pwd") String pwd);

    /**
     * author:Hulake
     * @param DID:用户的id
     * @return
     */
    @Select("select * from user where ID=#{DID}")
    User getUsername(int DID);

    @Select("<script>select ID,RealName from user where 1=1" +
            "<if test=\"Did!=null and Did!=''\">and ID=#{Did}</if>" +
            "<if test=\"rid!=null and rid!=''\">and RegistLeID=#{rid}</if>" +
            "</script>")
    java.util.List<User> getdeptusername(@Param(value = "Did")int Did, @Param(value = "rid")int rid);

}
