package com.heu.his.service;

import com.heu.his.Iservice.IUserService;
import com.heu.his.mapper.UserMapper;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{


    UserMapper userMapper;


    public User validate(String rn, String pwd) {
        return userMapper.validate(rn, pwd);
    }
	

    public List<User> getUserList(String name, Integer id) {
        return userMapper.getUserList(name,id);
    }
}

