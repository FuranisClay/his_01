package com.heu.his.controller;

import com.heu.his.Iservice.IRegisterCqService;
import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Drugs;
import com.heu.his.pojo.Register;
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
    public java.util.List<Integer> selectAmountById(int id){
        return iRegisterCqService.selectDrugsAmountById(id);
    }
    @RequestMapping("/selectCheckApply")
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return iRegisterCqService.selectCheckApplyByRegistId(id);
    };
}

