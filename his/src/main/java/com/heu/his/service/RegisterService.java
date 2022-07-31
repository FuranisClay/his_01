package com.heu.his.service;

import com.heu.his.Iservice.IRegisterService;
import com.heu.his.mapper.RegisterMapper;
import com.heu.his.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    RegisterMapper registerMapper;


    public List<Register> getRegisterListAndRL(String rn) {
        return registerMapper.getRegisterListAndRL(rn);
    }
}
