package com.heu.his.controller;


import com.heu.his.Iservice.IChargeSylService;
import com.heu.his.pojo.Patientcosts;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/charge")
public class ChargeSylController {

    @Autowired
    IChargeSylService chargeService;

    //
    @RequestMapping("/selectByCaseNumberAndName")
    public java.util.List<Register> selectByCaseNumberAndName(@Param("realName") String realName, @Param("caseNumber") String caseNumber){
        return chargeService.selectByNameNumber(realName,caseNumber);
    }

    @RequestMapping("/selectByRegisterid")
    public java.util.List<Patientcosts> selectByRegisterID(@Param("registerid")String registerid){
        return chargeService.selectByRegisterID(registerid);
    }
}
