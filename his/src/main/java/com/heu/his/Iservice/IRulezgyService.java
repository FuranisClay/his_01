package com.heu.his.Iservice;

import com.heu.his.pojo.Rule;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-05 10:03
 */
public interface IRulezgyService {

    List<Rule> getRuleList(int deptno);

    int deletesById(int[] arr);

    int getRuleMaxID();

    int insertRule(int id,String ruleName,int deptid,int userid,String week);
}
