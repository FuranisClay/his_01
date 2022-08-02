package com.heu.his.Iservice;

import com.heu.his.pojo.Expenseclass;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-01 11:26
 */
public interface IExpenseclassService {
    Expenseclass getExpenseclassByID(int id);
    List<Expenseclass> getExpenseclassList();

}
