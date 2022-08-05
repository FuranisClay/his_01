package com.heu.his.service;

import com.heu.his.Iservice.IRegistlevelService;
import com.heu.his.mapper.RegistlevelMapper;
import com.heu.his.pojo.Registlevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 17:02
 */
@Service
public class RegistlevelService implements IRegistlevelService {

    @Autowired
    RegistlevelMapper registlevelMapper;

    @Override
    public int insertRegistlevel(Registlevel registlevel) {
        return registlevelMapper.insertRegistlevel(registlevel);
    }

    @Override
    public int deleteRegistlevelById(int id) {
        return registlevelMapper.deleteRegistlevelById(id);
    }

    @Override
    public int updateRegistlevelById(Registlevel registlevel) {
        return registlevelMapper.updateRegistlevelById(registlevel);
    }

    @Override
    public int getRegistlevelMaxId() {
        return registlevelMapper.getRegistlevelMaxId();
    }

    @Override
    public List<Registlevel> getRegistlevelList(String string) {
        return registlevelMapper.getRegistlevelList(string);
    }

}
