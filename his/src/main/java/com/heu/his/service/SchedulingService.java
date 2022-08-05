package com.heu.his.service;

import com.heu.his.Iservice.ISchedulingService;
import com.heu.his.mapper.SchedulingMapper;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:19
 */
@Service
public class SchedulingService implements ISchedulingService {

    @Autowired
    SchedulingMapper schedulingMapper;

    @Override
    public List<Scheduling> getSchedulingList() {
        return schedulingMapper.getSchedulingList();
    }
}
