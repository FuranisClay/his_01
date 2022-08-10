package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IRegisterchService;
import com.heu.his.mapper.RegisterchMapper;
import com.heu.his.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterchService implements IRegisterchService {

    @Autowired
    RegisterchMapper registerMapper;

    public int addRegist(Register register) {
        return registerMapper.addRegist(register);
    }

    public int delregist(int cn) {
        return registerMapper.delregist(cn);
    }

    public int updatereg(Register register) {
        return registerMapper.updatereg(register);
    }

    public List<Register> getRegisterListAndRL(String rn, int cn, String uid) {
        return registerMapper.getRegisterListAndRL(rn,cn,uid);
    }

    public Register getRegistcostList(String rn) {
        return registerMapper.getRegistcostList(rn);
    }
}
