package com.heu.his.controller;


import com.heu.his.Iservice.IDiseaseService;
import com.heu.his.pojo.Constantitem;

import com.heu.his.pojo.Disease;

import com.heu.his.pojo.Disecategory;
import com.heu.his.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    IDiseaseService diseaseService;
    @RequestMapping("/list")
    public java.util.List<Disease> list(String diseaseName, int id){
        return diseaseService.getDrugsList(diseaseName,id);
    }
    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return diseaseService.deleteById(id);
    }
    @RequestMapping("/insertDrugs")
    public int insertDrugs(Disease disease){
        java.util.List<Disease> list = diseaseService.getDrugsList("", (int) disease.getId());
        if(list!=null){
            diseaseService.deleteById((int) disease.getId());
        }
        return diseaseService.insertDrugs(disease);
//        return 0;
    }
    @RequestMapping("/getConstantItem")
    public java.util.List<Disecategory> getConstantitemById(){
        return diseaseService.getConstantitemById();
    };
    @RequestMapping("updateDrugs")
    public boolean updateDrugsById(Disease disease){
//        drugs.setCreationDate();
        return diseaseService.updateById(disease);
    }
}
