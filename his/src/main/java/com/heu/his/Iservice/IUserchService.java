package com.heu.his.Iservice;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.User;

public interface IUserchService {

    User validate(String rn,String pwd);
}