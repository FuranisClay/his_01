package com.heu.his.controller;

import com.heu.his.pojo.Medicalrecord;
import com.heu.his.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/medicalrecord")
public class MedicalrecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    @RequestMapping("/list")
    public java.util.List<Medicalrecord> list(int casenum){return medicalRecordService.getMedicalrecordList(casenum);}

}
