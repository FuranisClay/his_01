package com.heu.his.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.heu.his.Iservice.IFmeditemService;
import com.heu.his.pojo.Fmeditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @RequestMapping("/delete")
    public int deleteFmeditem(int id){
        return fmeditemService.deleteFmeditemById(id);
    }

    @RequestMapping("/update")
    public int updateFmeditem(Fmeditem fmeditem) throws ParseException {
        Fmeditem fmeditem1 = new Fmeditem();
        fmeditem1.setId(fmeditem.getId());
        fmeditem1.setItemCode(fmeditem.getItemCode());
        fmeditem1.setItemName(fmeditem.getItemName());
        fmeditem1.setFormat(fmeditem.getFormat());
        fmeditem1.setPrice(fmeditem.getPrice());
        fmeditem1.setExpClassId(fmeditem.getExpClassId());
        fmeditem1.setDeptId(fmeditem.getDeptId());
        fmeditem1.setMnemonicCode(fmeditem.getMnemonicCode());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        fmeditem1.setLastUpdateDate(timestamp);

        System.out.println(fmeditem1.toString());
        return fmeditemService.updateFmeditemById(fmeditem1);
    }

    @RequestMapping("/maxid")
    public int getMaxId(){
        return fmeditemService.getFmeditemMaxId();
    }

}
