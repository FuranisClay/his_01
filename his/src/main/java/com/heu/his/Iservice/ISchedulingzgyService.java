package com.heu.his.Iservice;

import com.heu.his.pojo.Scheduling;

import java.util.Date;
import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:18
 */
public interface ISchedulingzgyService {

    List<Scheduling> getSchedulingList(String startTime,String endTime);

    int getSchedulingMaxID();

    int insertScheduling(Date scheddate, int deptid, int userid, String noon, int ruleid);

}
