package com.heu.his.mapper;

import com.heu.his.pojo.Expenseclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:42
 */
@Mapper
public interface ExpenseclassMapper {

    @Select("select * from expenseclass where ID = #{id}")
    Expenseclass getExpenseclassByID(int id);

    @Select("select * from expenseclass where DelMark=1")
    List<Expenseclass> getExpenseclassList();

}
