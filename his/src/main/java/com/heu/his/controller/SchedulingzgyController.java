package com.heu.his.controller;

import com.heu.his.Iservice.ISchedulingzgyService;
import com.heu.his.pojo.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-29 16:25
 */
@CrossOrigin
@RestController
@RequestMapping("/schedulingzgy")
@Scope("session")
public class SchedulingzgyController {

    @Autowired
    ISchedulingzgyService schedulingService;

    public static int id = 86;

    @RequestMapping("/add")
    public int addSchedule(String scheddate, int deptid, int userid, String noon, int ruleid) throws ParseException {
        if (noon == "00") {
            return 1;
        } else {
            int num = 0;
            String non = "";
            for (int i = 0; i < noon.length(); i++) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(scheddate);
                if (noon.charAt(i) == '0') {
                    continue;
                } else {
                    if (i == 0) {
                        non = "上午";
                        num++;
                    } else {
                        non = "下午";
                        num++;
                    }
                    id++;
                    schedulingService.insertScheduling(id, date, deptid, userid, non, ruleid);
                }
            }
        }
        return 0;
    }

    @RequestMapping("/maxid")
    public int getMaxID() {
        return schedulingService.getSchedulingMaxID();
    }

    @RequestMapping("/list")
    public List<Scheduling> getSchedulingList(String string) {
        if (string == null) {
            return schedulingService.getSchedulingList("", "");
        } else {
            String startTime = string.substring(0, string.indexOf(','));
            String endTime = string.substring(string.indexOf(',') + 1, string.length());
            return schedulingService.getSchedulingList(startTime, endTime);
        }
    }

}
