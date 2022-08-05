package com.heu.his.service;

import com.heu.his.Iservice.IExpenseclassService;
import com.heu.his.mapper.ExpenseclassMapper;
import com.heu.his.pojo.Expenseclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-01 11:27
 */
@Service
public class ExpenseclassService implements IExpenseclassService {

    @Autowired
    ExpenseclassMapper expenseclassMapper;

    @Override
    public Expenseclass getExpenseclassByID(int id) {
        return expenseclassMapper.getExpenseclassByID(id);
    }

    @Override
    public List<Expenseclass> getExpenseclassList() {
        return expenseclassMapper.getExpenseclassList();
    }
}
