package com.heu.his.controller;

import com.heu.his.Iservice.IDrugsCqService;
import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Drugs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author legend
 * @create 2022-07-30-15:35
 */
@CrossOrigin
@RestController
@RequestMapping("/drugsCq")
public class DrugsCqController {

    @Autowired
    IDrugsCqService iDrugsCqService;
    @RequestMapping("/list")
    public java.util.List<Drugs> list(String drugsName, int id){
        return iDrugsCqService.getDrugsList(drugsName,id);
    }
    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return iDrugsCqService.deleteById(id);
    }
    @RequestMapping("/insertDrugs")
    public int insertDrugs(Drugs drugs){
        java.util.List<Drugs> list = iDrugsCqService.getDrugsList("", (int) drugs.getId());
        if(list!=null){
            iDrugsCqService.deleteById((int) drugs.getId());
        }
        return iDrugsCqService.insertDrugs(drugs);
//        return 0;
    }
    @RequestMapping("/getConstantItem")
    public java.util.List<Constantitem> getConstantitemById(){
        return iDrugsCqService.getConstantitemById();
    };
    @RequestMapping("updateDrugs")
    public boolean updateDrugsById(Drugs drugs){
//        drugs.setCreationDate();
        return iDrugsCqService.updateById(drugs);
    }
}