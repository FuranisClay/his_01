package com.heu.his.service;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.Iservice.IUserchService;
import com.heu.his.mapper.UserchMapper;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserchService implements IUserchService {

    @Autowired
    UserchMapper userMapper;

    public User validate(String rn, String pwd) {
        return userMapper.validate(rn, pwd);
    }
    public java.util.List<User> getdeptusername(int Did, int rid){return userMapper.getdeptusername(Did,rid);}
}

