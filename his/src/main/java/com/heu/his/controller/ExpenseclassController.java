package com.heu.his.controller;

import com.heu.his.Iservice.IExpenseclassService;
import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Expenseclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-01 11:46
 */
@CrossOrigin
@RestController
@RequestMapping("expenseclass")
public class ExpenseclassController {

    @Autowired
    IExpenseclassService expenseclassService;

    @RequestMapping("/expenseclasslist")
    public List<Expenseclass> getExpenseclassList(){
        return expenseclassService.getExpenseclassList();
    }

}
