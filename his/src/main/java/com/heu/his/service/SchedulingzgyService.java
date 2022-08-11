package com.heu.his.service;

import com.heu.his.Iservice.ISchedulingzgyService;
import com.heu.his.mapper.SchedulingzgyMapper;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:19
 */
@Service
public class SchedulingzgyService implements ISchedulingzgyService {

    @Autowired
    SchedulingzgyMapper schedulingzgyMapper;

    @Override
    public List<Scheduling> getSchedulingList(String startTime,String endTime) {
        return schedulingzgyMapper.getSchedulingList(startTime,endTime);
    }

    @Override
    public int insertScheduling(Date scheddate, int deptid, int userid, String noon, int ruleid) {
        return schedulingzgyMapper.insertScheduling(scheddate,deptid,userid,noon,ruleid);
    }

    @Override
    public int getSchedulingMaxID() {
        return schedulingzgyMapper.getSchedulingMaxID();
    }
}
