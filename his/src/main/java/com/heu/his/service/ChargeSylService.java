package com.heu.his.service;

import com.heu.his.Iservice.IChargeSylService;
import com.heu.his.mapper.PatientCostsSylMapper;
import com.heu.his.mapper.RegisterCqMapper;
import com.heu.his.pojo.Patientcosts;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeSylService implements IChargeSylService {
    @Autowired
    RegisterCqMapper registerMapper;
    @Autowired
    PatientCostsSylMapper patientCostsSylMapper;

    @Override
    public List<Patientcosts> selectByRegisterID(String registerid) {
        return patientCostsSylMapper.selectByRegisterID(registerid);
    }

    @Override
    public List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber) {
        return registerMapper.selectByNameNumber(realName,caseNumber);
    }
}
