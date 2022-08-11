package com.heu.his.service;

import com.heu.his.Iservice.IRegisterCqService;
import com.heu.his.mapper.RegisterCqMapper;
import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author legend
 * @create 2022-07-31-9:41
 */
@Service
public class RegisterCqService implements IRegisterCqService {
    @Autowired
    RegisterCqMapper registerCqMapper;
    public java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber){
        return registerCqMapper.selectByNameNumber(realName,caseNumber);
    }
    public java.util.List<Drugs> selectDrugsByRegisterId(int id){
        return registerCqMapper.selectDrugsByRegisterId(id);
    };
    public java.util.List<Integer> selectDrugsAmountById(@Param("registerId") Integer registerId,@Param("drugsId") Integer drugsId){
        return registerCqMapper.selectDrugsAmountById(registerId,drugsId);
    };
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return registerCqMapper.selectCheckApplyByRegistId(id);
    };
    public Fmeditem getFmeditemById(int id){
        return registerCqMapper.getFmeditemById(id);
    };
    public int setDrugsState(int id,int state){
        return registerCqMapper.setDrugsState(id,state);
    }
    public java.util.List<Integer> selectPreIdById(int id){
        return registerCqMapper.selectPreIdById(id);
    };
    public int setCheckState(Checkapply checkapply){
        return registerCqMapper.setCheckState(checkapply);
    };
    public java.util.List<Prescriptiondetailed> selectPreById(int id){
        return registerCqMapper.selectPreById(id);
    };

    public int insertPre(Prescriptiondetailed prescriptiondetailed){
        return registerCqMapper.insertPre(prescriptiondetailed);
    };
    public int insertMedical(Medicalrecord medicalrecord){
        return registerCqMapper.insertMedical(medicalrecord);
    };
    public int insertPr(Prescription prescription){
        return registerCqMapper.insertPr(prescription);
    };
    public java.util.List<Medicalrecord> selectAllM(){
        return registerCqMapper.selectAllM();
    };
    public java.util.List<Prescriptiondetailed> selectAllP(){
        return registerCqMapper.selectAllP();
    };
    public java.util.List<Prescription> selectByRID(int id){
        return registerCqMapper.selectByRID(id);
    };

    public int insertPatientCost(Patientcosts patientcosts){
        return registerCqMapper.insertPatientCost(patientcosts);
    };

    public int insertCheckApply(Checkapply checkapply){
        return registerCqMapper.insertCheckApply(checkapply);
    };
    public java.util.List<Medicalrecord> selectM(int id){
        return registerCqMapper.selectM(id);
    };
}
