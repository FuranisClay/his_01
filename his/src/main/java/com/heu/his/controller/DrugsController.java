package com.heu.his.controller;

import com.heu.his.Iservice.IDrugsService;
import com.heu.his.pojo.Constantitem;
import com.heu.his.pojo.Drugs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author legend
 * @create 2022-07-30-15:35
 */
@CrossOrigin
@RestController
@RequestMapping("/drugs")
public class DrugsController {

    @Autowired
    IDrugsService iDrugsService;
    @RequestMapping("/list")
    public java.util.List<Drugs> list(String drugsName, int id){
        return iDrugsService.getDrugsList(drugsName,id);
    }
    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return iDrugsService.deleteById(id);
    }
    @RequestMapping("/insertDrugs")
    public int insertDrugs(Drugs drugs){
        return iDrugsService.insertDrugs(drugs);
//        return 0;
    }
    @RequestMapping("/getConstantItem")
    public java.util.List<Constantitem> getConstantitemById(){
        return iDrugsService.getConstantitemById();
    };
}