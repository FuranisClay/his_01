package com.heu.his.mapper;

import com.heu.his.pojo.Constantitem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 11:04
 */
@Mapper
public interface ConstantItemMapper {

    @Select("select * from constantitem where ID=#{id}")
    Constantitem getConstantItemByID(int id);

    @Select("select * from constantitem where ConstantTypeID=1")
    List<Constantitem> getDepartmentCategoryList();

}
