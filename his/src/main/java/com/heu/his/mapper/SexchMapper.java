package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Registlevel;
import com.heu.his.pojo.Sex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SexchMapper {

    /**
     * author:Hulake
     * 查询性别
     * @return
     */
    @Select("select * from sex")
    java.util.List<Sex> getsexnamelist();

    /**
     * author:Hulake
     * 查询挂号代号的级别
     * @param id：挂号代号
     * @return
     */
    @Select("select * from sex where ID=#{id}")
    Sex getsexname(int id);
}
