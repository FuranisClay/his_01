package com.heu.his.Iservice;

import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.Param;

/**
 * author:Hulake
 * time:2022/8/6
 */

public interface ISchedulingchService {

    java.util.List<Scheduling> getusernamelist(@Param(value = "deptId")int deptId,
                                               @Param(value = "vdate")String vdate,
                                               @Param(value = "noon")String noon);
}
