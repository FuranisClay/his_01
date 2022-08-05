package com.heu.his.service;

import com.heu.his.Iservice.IConstantItemService;
import com.heu.his.mapper.ConstantItemMapper;
import com.heu.his.pojo.Constantitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 9:36
 */

@Service
public class ConstantItemService implements IConstantItemService {

    @Autowired
    ConstantItemMapper constantItemMapper;

    @Override
    public List<Constantitem> getDepartmentCategoryList() {
        return constantItemMapper.getDepartmentCategoryList();
    }
}
