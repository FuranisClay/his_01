package com.heu.his.Iservice;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;

public interface IRegisterchService {

    java.util.List<Register> getRegisterListAndRL(String rn,int cn,int uid);
    Register getRegistcostList(@Param(value = "rn") String rn);
    int addRegist(Register register);
    int delregist(int cn);
    boolean updatereg(Register register);
}
