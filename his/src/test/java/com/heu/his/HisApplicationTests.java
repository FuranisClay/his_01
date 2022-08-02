package com.heu.his;

import com.heu.his.mapper.DrugsCqMapper;
import com.heu.his.mapper.RegisterCqMapper;
import com.heu.his.pojo.Drugs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class HisApplicationTests {
    @Autowired
    DrugsCqMapper drugsCqMapper;
    @Autowired
    RegisterCqMapper registerCqMapper;
    @Test
    void contextLoads() {

        //测试查询药品
//        java.util.List<Drugs> list=drugsMapper.getDrugsList("心",0);
//        for (Drugs d:list){
//            System.out.println(d.toString());
//        }
        //测试获取药剂类型
//        java.util.List<Constantitem> list=drugsMapper.getConstantitemById();
//        for (Constantitem c:list){
//            System.out.println(c.toString());
//        }

//        //测试添加药品
//        Drugs drugs = new Drugs();
//        drugs.setId(2972);
//        drugs.setDrugsCode("754545544");
//        drugs.setDrugsName("cqcqcqc");
//        Timestamp timestamp = new Timestamp(2019-03-01);
//        drugs.setCreationDate(timestamp);
//        drugsCqMapper.insertDrugs(drugs);

        //测试通过患者病历号查询对应药品信息
//        java.util.List<Drugs> drugs=registerMapper.selectDrugsByRegisterId(37);
//        for (Drugs d:drugs) {
//            System.out.println(d.toString());
//        }
//
//        java.util.List<Integer> amount = registerMapper.selectDrugsAmountById(37);
//        System.out.println(amount);

        //测试通过id查询病历号对应项目信息
//        java.util.List<Checkapply> checkapply = registerMapper.selectCheckApplyByRegistId(9);
//        System.out.println(checkapply.toString());

    }

}
