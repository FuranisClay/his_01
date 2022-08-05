package com.heu.his.controller;

import com.heu.his.Iservice.IRegistlevelService;
import com.heu.his.pojo.Registlevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 17:04
 */
@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegistlevelController {

    @Autowired
    IRegistlevelService registlevelService;

    @RequestMapping("/list")
    public List<Registlevel> getRegistList(String string){
        return registlevelService.getRegistlevelList(string);
    }

    @RequestMapping("/update")
    public int updateRegist(Registlevel registlevel){
        System.out.println(registlevel.toString());
        return registlevelService.updateRegistlevelById(registlevel);
    }

    @RequestMapping("/delete")
    public int deleteRegist(Integer id){
        System.out.println(id);
        return registlevelService.deleteRegistlevelById(id);
    }

    @RequestMapping("/maxid")
    public int getMaxId(){
        return registlevelService.getRegistlevelMaxId();
    }

    @RequestMapping("/add")
    public int addRegist(Registlevel registlevel){
        System.out.println(registlevel.toString());
        return registlevelService.insertRegistlevel(registlevel);
    }

}
