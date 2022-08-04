package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IPatientcostschService;
import com.heu.his.mapper.PatientcostschMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientcostschService implements IPatientcostschService {

    @Autowired
    PatientcostschMapper patientcostsMapper;


}
