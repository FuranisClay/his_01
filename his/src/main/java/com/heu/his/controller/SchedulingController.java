package com.heu.his.controller;

import com.heu.his.Iservice.ISchedulingService;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:25
 */
@CrossOrigin
@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    ISchedulingService schedulingService;

    @RequestMapping("/list")
    public List<Scheduling> getSchedulingList(){
        return schedulingService.getSchedulingList();
    }

}
