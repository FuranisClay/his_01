package com.heu.his.controller;

import com.heu.his.Iservice.IRegisterService;
import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Drugs;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author legend
 * @create 2022-07-31-9:42
 */
@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    IRegisterService iRegisterService;
    @RequestMapping("/selectRegister")
    public java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber){
        return iRegisterService.selectByNameNumber(realName,caseNumber);
    }
    @RequestMapping("/selectDrugs")
    public java.util.List<Drugs> selectDrugsByRegisterId(int id){
        return iRegisterService.selectDrugsByRegisterId(id);
    };
    @RequestMapping("/selectAmount")
    public java.util.List<Integer> selectAmountById(int id){
        return iRegisterService.selectDrugsAmountById(id);
    }
    @RequestMapping("/selectCheckApply")
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return iRegisterService.selectCheckApplyByRegistId(id);
    };
}

