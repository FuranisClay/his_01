package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IRegistlevelchService;
import com.heu.his.mapper.RegistlevelchMapper;
import com.heu.his.pojo.Registlevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistlevelchService implements IRegistlevelchService {

    @Autowired
    RegistlevelchMapper registlevelMapper;

    public List<Registlevel> getRegistlevelname() {
        return registlevelMapper.getRegistlevelname();
    }

    public int getreqistlevelmoney(int id) {
        return registlevelMapper.getreqistlevelmoney(id);
    }
}
