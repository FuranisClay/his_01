package com.heu.his.service;

import com.heu.his.Iservice.ISchedulingchService;
import com.heu.his.mapper.SchedulingchMapper;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:Hulake
 * time:2022/8/6
 */

@Service
public class SchedulingchService implements ISchedulingchService {
    
    @Autowired
    SchedulingchMapper schedulingchMapper;

    public List<Scheduling> getusernamelist(int deptId, String vdate, String noon) {
        return schedulingchMapper.getusernamelist(deptId, vdate, noon);
    }
}
