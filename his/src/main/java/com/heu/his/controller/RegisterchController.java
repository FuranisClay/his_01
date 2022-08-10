package com.heu.his.controller;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IRegisterchService;
import com.heu.his.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@CrossOrigin
@RestController
@RequestMapping("/registerch")
public class RegisterchController {

    @Autowired
    IRegisterchService registerchService;

    /**
     * author:Hulake
     * 根据患者身份查询患者信息
     * @param rn：患者姓名
     * @param cn：患者病历号
     * @param uid：患者身份证
     * @return
     */
    @RequestMapping("/list")
    public java.util.List<Register> list(String rn,int cn,String uid){
        return registerchService.getRegisterListAndRL(rn,cn,uid);
    }

    /**
     * author:Hulake
     * 添加挂号患者信息
     * @param register
     * @return
     */
    @RequestMapping("/regadd")
    public int regadd(Register register){
        System.out.println(register);
//        return 0;
        return registerchService.addRegist(register);
    }

    @RequestMapping("/updatereg")
    public int updatereg(Register register){
        System.out.println(register);
        return registerchService.updatereg(register);
    }

    /**
     * 删除挂号信息
     * @param cn:病例号
     * @return
     */
    @RequestMapping("/delrigist")
    public int delrigist(int cn){
        System.out.println(cn);
        return registerchService.delregist(cn);
    }

    /**
     * author:Hulake
     * 查询患者花费项目
     * @param rn：患者姓名
     * @return
     */
    @RequestMapping("/costlist")
    public Register costlist(String rn) {
        return registerchService.getRegistcostList(rn);
    }
}
