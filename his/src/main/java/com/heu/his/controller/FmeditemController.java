package com.heu.his.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.heu.his.Iservice.IFmeditemService;
import com.heu.his.pojo.Fmeditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:02
 */
@CrossOrigin
@RestController
@RequestMapping("/fmeditem")
public class FmeditemController {

    @Autowired
    IFmeditemService fmeditemService;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    @RequestMapping("/list")
    public List<Fmeditem> getList(){
        return fmeditemService.getFmeditemList();
    }

}
