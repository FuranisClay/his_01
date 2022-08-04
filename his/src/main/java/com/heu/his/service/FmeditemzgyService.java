package com.heu.his.service;

import com.heu.his.Iservice.IFmeditemzgyService;
import com.heu.his.mapper.FmeditemzgyMapper;
import com.heu.his.pojo.Fmeditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:01
 */
@Service
public class FmeditemzgyService implements IFmeditemzgyService {

    @Autowired
    FmeditemzgyMapper fmeditemzgyMapper;

    @Override
    public int updateFmeditemById(Fmeditem fmeditem) {
        return fmeditemzgyMapper.updateFmeditemById(fmeditem);
    }

    @Override
    public int insertFmeditem(Fmeditem fmeditem) {
        return fmeditemzgyMapper.insertFmeditem(fmeditem);
    }

    @Override
    public int deleteFmeditemById(int id) {
        return fmeditemzgyMapper.deleteFmeditemById(id);
    }

    @Override
    public int getFmeditemMaxId() {
        return fmeditemzgyMapper.getFmeditemMaxId();
    }

    @Override
    public List<Fmeditem> getFmeditemList(String string) {
        return fmeditemzgyMapper.getFmeditemList(string);
    }
}
