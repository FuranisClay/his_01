package com.heu.his.controller;

import com.heu.his.Iservice.ISchedulingchService;
import com.heu.his.pojo.Scheduling;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/schedulingch")
public class SchedulingchController {

    @Autowired
    ISchedulingchService schedulingchService;
    
    @RequestMapping("/list")
    public java.util.List<Scheduling> list(int deptId, String vdate, String noon){
        return schedulingchService.getusernamelist(deptId, vdate, noon);}
}
