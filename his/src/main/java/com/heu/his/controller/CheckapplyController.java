package com.heu.his.controller;

import com.heu.his.Iservice.ICheckApplyService;
import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Disecategory;
import com.heu.his.pojo.Drugs;
import com.heu.his.service.CheckApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/checkapply")
public class CheckapplyController {
    @Autowired
    CheckApplyService checkApplyService;

    @RequestMapping("/list")
    public java.util.List<Checkapply> list(int rid){return checkApplyService.getcheckBycasenum(rid);}

    @RequestMapping("/list1")
    public java.util.List<Checkapply> list(String name, int id){
        return checkApplyService.getDrugsList(name,id);
    }
    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return checkApplyService.deleteById(id);
    }
    @RequestMapping("/insertDrugs")
    public int insertDrugs(Checkapply checkapply){
        java.util.List<Checkapply> list = checkApplyService.getDrugsList("", (int) checkapply.getId());
        if(list!=null){
            checkApplyService.deleteById((int) checkapply.getId());
        }
        return checkApplyService.insertDrugs(checkapply);
//        return 0;
    }
    @RequestMapping("/getConstantItem")
    public java.util.List<Disecategory> getConstantitemById(){
        return checkApplyService.getConstantitemById();
    };
    @RequestMapping("updateDrugs")
    public boolean updateDrugsById(Checkapply checkapply ){
//        drugs.setCreationDate();
        return checkApplyService.updateById(checkapply);
    }
}
