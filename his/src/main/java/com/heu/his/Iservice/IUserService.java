package com.heu.his.Iservice;

import com.heu.his.pojo.User;

import java.util.List;

public interface IUserService {
	
	List<User> getUserList(String name, Integer id);

    User validate(String rn,String pwd);
}
