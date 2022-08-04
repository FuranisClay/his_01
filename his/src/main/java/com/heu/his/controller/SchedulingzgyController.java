package com.heu.his.controller;

import com.heu.his.Iservice.ISchedulingzgyService;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:25
 */
@CrossOrigin
@RestController
@RequestMapping("/schedulingzgy")
public class SchedulingzgyController {

    @Autowired
    ISchedulingzgyService schedulingService;

    @RequestMapping("/list")
    public List<Scheduling> getSchedulingList(String string) {
        if (string==null){
            return schedulingService.getSchedulingList("", "");
        }else {
            String startTime = string.substring(0, string.indexOf(','));
            String endTime = string.substring(string.indexOf(',') + 1, string.length());
            return schedulingService.getSchedulingList(startTime, endTime);
        }
    }

}
