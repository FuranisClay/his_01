package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Registlevel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RegistlevelchMapper {

    @Select("select RegistFee from registlevel where ID=#{id}")
    int getreqistlevelmoney(int id);

    /**
     * author:Hulake
     * 查询挂号的患者
     * @param id：挂号代号
     * @return
     */
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "emps",column = "id",many = @Many(select = "com.heu.his.mapper.RegisterchMapper.getRegistListByRL"))
    })
    @Select("select * from registlevel where ID=#{id}")
    Registlevel getRegistlevelById(int id);


    /**
     * author:Hulake
     * 查询挂号代号的级别
     * @param id：挂号代号
     * @return
     */
    @Select("select * from registlevel where ID=#{id}")
    Registlevel getRegistlevelByIdOne(int id);


    /**
     * author:Hulake
     * 查询挂号的所有级别
     * @return
     */
    @Select("select * from registlevel")
    java.util.List<Registlevel> getRegistlevelname();
}
