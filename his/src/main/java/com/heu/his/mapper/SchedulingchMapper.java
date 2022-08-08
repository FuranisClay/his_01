package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/6
 */

import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SchedulingchMapper {
    
    @Select("<script>select UserID from scheduling where 1+1" +
            "<if test=\"deptId!=null and deptId!=''\">and DeptID=#{deptId}</if>" +
            "<if test=\"vdate!=null and vdate!=''\">and SchedDate=#{vdate}</if>" +
            "<if test=\"noon!=null and noon!=''\">and Noon=#{noon}</if>" +
            "</script>")
    java.util.List<Scheduling> getusernamelist(@Param(value = "deptId")int deptId, 
                                               @Param(value = "vdate")String vdate,
                                               @Param(value = "noon")String noon);
}
