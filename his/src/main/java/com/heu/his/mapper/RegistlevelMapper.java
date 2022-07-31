package com.heu.his.mapper;

import com.heu.his.pojo.Registlevel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RegistlevelMapper {

    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "emps",column = "id",many = @Many(select = "com.heu.his.mapper.RegisterMapper.getRegistListByRL"))
    })
    @Select("select * from registlevel where ID=#{id}")
    Registlevel getRegistlevelById(int id);

    @Select("select * from registlevel where ID=#{id}")
    Registlevel getRegistlevelByIdOne(int id);
}
