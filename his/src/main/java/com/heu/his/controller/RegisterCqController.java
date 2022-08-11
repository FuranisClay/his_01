package com.heu.his.controller;

import com.heu.his.Iservice.IRegisterCqService;
import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author legend
 * @create 2022-07-31-9:42
 */
@CrossOrigin
@RestController
@RequestMapping("/registerCq")
public class RegisterCqController {
    @Autowired
    IRegisterCqService iRegisterCqService;
    @RequestMapping("/selectRegister")
    public java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber){
        return iRegisterCqService.selectByNameNumber(realName,caseNumber);
    }
    @RequestMapping("/selectDrugs")
    public java.util.List<Drugs> selectDrugsByRegisterId(int id){
        return iRegisterCqService.selectDrugsByRegisterId(id);
    };
    @RequestMapping("/selectAmount")
    public java.util.List<Integer> selectDrugsAmountById(@Param("registerId") Integer registerId,@Param("drugsId") Integer drugsId){
        return iRegisterCqService.selectDrugsAmountById(registerId,drugsId  );
    }
    @RequestMapping("/selectCheckApply")
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return iRegisterCqService.selectCheckApplyByRegistId(id);
    };
    @RequestMapping("/setState")
    public int setDrugsState(int id,int state){
        return iRegisterCqService.setDrugsState(id,state);
    }
    @RequestMapping("/getPreId")
    public java.util.List<Integer> selectPreIdById(int id){
        return iRegisterCqService.selectPreIdById(id);
    };
    @RequestMapping("/updateCheck")
    public int setCheckState(Checkapply checkapply){
//        System.out.println(checkapply.getId()+">>>>>");
//        return 0;
        return iRegisterCqService.setCheckState(checkapply);
    };
    @RequestMapping("/selectPreById")
    public  java.util.List<Prescriptiondetailed> selectPreById(int id){
        return iRegisterCqService.selectPreById(id);
    };
    @RequestMapping("/insertPre")
    public int insertPre(Prescriptiondetailed prescriptiondetailed){
        return iRegisterCqService.insertPre(prescriptiondetailed);
    };
    @RequestMapping("/insertMedical")
    public int insertMedical(Medicalrecord medicalrecord){
        return iRegisterCqService.insertMedical(medicalrecord);
    };
    @RequestMapping("/insertPr")
    public int insertPr(Prescription prescription){
        return iRegisterCqService.insertPr(prescription);
    };
    @RequestMapping("/selectAllM")
    public java.util.List<Medicalrecord> selectAllM(){
        return iRegisterCqService.selectAllM();
    };
    @RequestMapping("/selectAllP")
    public java.util.List<Prescriptiondetailed> selectAllP(){
        return iRegisterCqService.selectAllP();
    };
    @RequestMapping("/selectPByRId")
    public java.util.List<Prescription> selectByRID(int id){
        return iRegisterCqService.selectByRID(id);
    };
    @RequestMapping("/insertPatientcosts")
    public int insertPatientCost(Patientcosts patientcosts){
        return iRegisterCqService.insertPatientCost(patientcosts);
    };
    @RequestMapping("/insertCheckApply")
    public int insertCheckApply(Checkapply checkapply){
        return iRegisterCqService.insertCheckApply(checkapply);
    };
    @RequestMapping("/selectM")
    public java.util.List<Medicalrecord> selectM(int id){
        return iRegisterCqService.selectM(id);
    };
}

