package com.heu.his.service;

import com.heu.his.Iservice.IConstantItemzgyService;
import com.heu.his.mapper.ConstantItemzgyMapper;
import com.heu.his.pojo.Constantitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 9:36
 */

@Service
public class ConstantItemzgyService implements IConstantItemzgyService {

    @Autowired
    ConstantItemzgyMapper constantItemzgyMapper;

    @Override
    public List<Constantitem> getDepartmentCategoryList() {
        return constantItemzgyMapper.getDepartmentCategoryList();
    }

    @Override
    public List<Constantitem> getDocTitleList() {
        return constantItemzgyMapper.getDocTitleList();
    }
}
