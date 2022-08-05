package com.heu.his.service;

import com.heu.his.Iservice.IFmeditemService;
import com.heu.his.mapper.FmeditemMapper;
import com.heu.his.pojo.Fmeditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:01
 */
@Service
public class FmeditemService implements IFmeditemService {

    @Autowired
    FmeditemMapper fmeditemMapper;

    @Override
    public int updateFmeditemById(Fmeditem fmeditem) {
        return fmeditemMapper.updateFmeditemById(fmeditem);
    }

    @Override
    public int deleteFmeditemById(int id) {
        return fmeditemMapper.deleteFmeditemById(id);
    }

    @Override
    public int getFmeditemMaxId() {
        return fmeditemMapper.getFmeditemMaxId();
    }


    @Override
    public List<Fmeditem> getFmeditemList() {
        return fmeditemMapper.getFmeditemList();
    }
}
