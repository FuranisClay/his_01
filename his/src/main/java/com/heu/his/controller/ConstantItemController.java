package com.heu.his.controller;

import com.heu.his.Iservice.IConstantItemService;
import com.heu.his.pojo.Constantitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 9:37
 */
@CrossOrigin
@RestController
@RequestMapping("/constantitem")
public class ConstantItemController {

    @Autowired
    IConstantItemService constantItemService;

    @RequestMapping("/categorylist")
    public List<Constantitem> getCategoryList(){
        return constantItemService.getDepartmentCategoryList();
    }

}
