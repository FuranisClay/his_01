package com.heu.his.service;

import com.heu.his.Iservice.IRegisterCqService;
import com.heu.his.mapper.RegisterCqMapper;
import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Drugs;
import com.heu.his.pojo.Fmeditem;
import com.heu.his.pojo.Register;
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
    public java.util.List<Integer> selectDrugsAmountById(int id){
        return registerCqMapper.selectDrugsAmountById(id);
    };
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return registerCqMapper.selectCheckApplyByRegistId(id);
    };
    public Fmeditem getFmeditemById(int id){
        return registerCqMapper.getFmeditemById(id);
    };
}
