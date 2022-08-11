package com.heu.his.Iservice;

import com.heu.his.pojo.*;
import org.apache.ibatis.annotations.Param;

/**
 * @author legend
 * @create 2022-07-31-10:10
 */
public interface IRegisterCqService {
    java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber);
    java.util.List<Drugs> selectDrugsByRegisterId(int id);
    java.util.List<Integer> selectDrugsAmountById(@Param("registerId") Integer registerId, @Param("drugsId") Integer drugsId);
    java.util.List<Checkapply> selectCheckApplyByRegistId(int id);
    Fmeditem getFmeditemById(int id);
    int setDrugsState(int id, int state);
    java.util.List<Integer> selectPreIdById(int id);
    int setCheckState(Checkapply checkapply);
    java.util.List<Prescriptiondetailed> selectPreById(int id);
    int insertPre(Prescriptiondetailed prescriptiondetailed);
    int insertMedical(Medicalrecord medicalrecord);
    int insertPr(Prescription prescription);
    java.util.List<Medicalrecord> selectAllM();
    java.util.List<Prescriptiondetailed> selectAllP();
    java.util.List<Prescription> selectByRID(int id);
    int insertPatientCost(Patientcosts patientcosts);
    int insertCheckApply(Checkapply checkapply);
    java.util.List<Medicalrecord> selectM(int id);

}
