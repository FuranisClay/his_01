package com.heu.his.service;

import com.heu.his.Iservice.IMedicalRecordService;
import com.heu.his.mapper.MedicalRecordMapper;
import com.heu.his.pojo.Medicalrecord;
import com.heu.his.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author legend
 * @create 2022-07-31-11:30
 */
@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    public List<Medicalrecord> getMedicalrecordList(int casenum) {
        return medicalRecordMapper.getMedicalrecordBycasenum(casenum);
    }

}
