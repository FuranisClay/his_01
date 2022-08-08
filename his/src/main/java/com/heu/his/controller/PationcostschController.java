package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IPatientcostschService;
import com.heu.his.pojo.Patientcosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/pationcostsch")
public class PationcostschController {

    @Autowired
    IPatientcostschService patientcostschService;
    
    @RequestMapping("/list")
    public java.util.List<Patientcosts> list(int RID){return patientcostschService.getPatientcostsList(RID);}
}
