package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IPatientcostschService;
import com.heu.his.mapper.PatientcostschMapper;
import com.heu.his.pojo.Patientcosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientcostschService implements IPatientcostschService {

    @Autowired
    PatientcostschMapper patientcostsMapper;

    public List<Patientcosts> getPatientcostsList(int RID) {
        return patientcostsMapper.getPatientcostsList(RID);
    }
}
