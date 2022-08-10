package com.heu.his.Iservice;

import com.heu.his.pojo.User;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-22 10:40
 */
public interface IUserzgyService {

    User validate(String ename,String pwd);

    List<User> getUserList(String name);

    int updateUserById(User user);

    int deleteUserById(int id);

    int getUserMaxID();

    int insertUser(User user);

    List<User> getUserListByDeptno(int deptno);

    List<User> getUserlistByDeptnoAndRegisterlevel(int deptno,int registlevel);

//    List<User> getUserListAndDept();

}
