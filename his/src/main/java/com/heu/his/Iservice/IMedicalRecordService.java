package com.heu.his.Iservice;

import com.heu.his.pojo.Medicalrecord;


/**
 * @author legend
 * @create 2022-07-31-11:31
 */
public interface IMedicalRecordService {
    java.util.List<Medicalrecord> getMedicalrecordList(int casenum);
}
