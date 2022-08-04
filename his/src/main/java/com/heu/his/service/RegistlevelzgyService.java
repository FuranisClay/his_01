package com.heu.his.service;

import com.heu.his.Iservice.IRegistlevelzgyService;
import com.heu.his.mapper.RegistlevelzgyMapper;
import com.heu.his.pojo.Registlevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 17:02
 */
@Service
public class RegistlevelzgyService implements IRegistlevelzgyService {

    @Autowired
    RegistlevelzgyMapper registlevelzgyMapper;

    @Override
    public int insertRegistlevel(Registlevel registlevel) {
        return registlevelzgyMapper.insertRegistlevel(registlevel);
    }

    @Override
    public int deleteRegistlevelById(int id) {
        return registlevelzgyMapper.deleteRegistlevelById(id);
    }

    @Override
    public int updateRegistlevelById(Registlevel registlevel) {
        return registlevelzgyMapper.updateRegistlevelById(registlevel);
    }

    @Override
    public int getRegistlevelMaxId() {
        return registlevelzgyMapper.getRegistlevelMaxId();
    }

    @Override
    public List<Registlevel> getRegistlevelList(String string) {
        return registlevelzgyMapper.getRegistlevelList(string);
    }

}
