package com.heu.his.service;

import com.heu.his.Iservice.IUserzgyService;
import com.heu.his.mapper.UserzgyMapper;
import com.heu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-22 10:40
 */
@Service
public class UserzgyService implements IUserzgyService {

    @Autowired
    UserzgyMapper userzgyMapper;

//    @Override
//    public List<User> getUserListAndDept() {
//        return userMapper.getUserListAndDept();
//    }

    @Override
    public User validate(String ename, String pwd) {
        return userzgyMapper.validate(ename,pwd);
    }

    @Override
    public int getUserMaxID() {
        return userzgyMapper.getUserMaxID();
    }

    @Override
    public int insertUser(User user) {
        return userzgyMapper.insertUser(user);
    }

    @Override
    public List<User> getUserList(String name) {
        return userzgyMapper.getUserList(name);
    }

    @Override
    public int deleteUserById(int id) {
        return userzgyMapper.deleteUserById(id);
    }

    @Override
    public int updateUserById(User user) {
        return userzgyMapper.updateUserById(user);
    }
}
