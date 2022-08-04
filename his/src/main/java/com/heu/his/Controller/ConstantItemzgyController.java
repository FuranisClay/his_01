package com.heu.his.Controller;

import com.heu.his.Iservice.IConstantItemzgyService;
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
@RequestMapping("/constantitemzgy")
public class ConstantItemzgyController {

    @Autowired
    IConstantItemzgyService constantItemService;

    @RequestMapping("/categorylist")
    public List<Constantitem> getCategoryList(){
        return constantItemService.getDepartmentCategoryList();
    }

    @RequestMapping("/doctitlelist")
    public List<Constantitem> getDocTitleList(){
        return constantItemService.getDocTitleList();
    }

}
