package com.heu.his.service;

import com.heu.his.Iservice.IRegisterService;
import com.heu.his.mapper.RegisterMapper;
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
public class RegisterService implements IRegisterService {
    @Autowired
    RegisterMapper registerMapper;
    public java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber){
        return registerMapper.selectByNameNumber(realName,caseNumber);
    }
    public java.util.List<Drugs> selectDrugsByRegisterId(int id){
        return registerMapper.selectDrugsByRegisterId(id);
    };
    public java.util.List<Integer> selectDrugsAmountById(int id){
        return registerMapper.selectDrugsAmountById(id);
    };
    public java.util.List<Checkapply> selectCheckApplyByRegistId(int id){
        return registerMapper.selectCheckApplyByRegistId(id);
    };
    public Fmeditem getFmeditemById(int id){
        return registerMapper.getFmeditemById(id);
    };
}
