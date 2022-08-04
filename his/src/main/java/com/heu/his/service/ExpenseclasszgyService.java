package com.heu.his.service;

import com.heu.his.Iservice.IExpenseclasszgyService;
import com.heu.his.mapper.ExpenseclasszgyMapper;
import com.heu.his.pojo.Expenseclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-01 11:27
 */
@Service
public class ExpenseclasszgyService implements IExpenseclasszgyService {

    @Autowired
    ExpenseclasszgyMapper expenseclasszgyMapper;

    @Override
    public List<Expenseclass> getExpenseclassList() {
        return expenseclasszgyMapper.getExpenseclassList();
    }
}
