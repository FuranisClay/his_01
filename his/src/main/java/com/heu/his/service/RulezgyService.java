package com.heu.his.service;

import com.heu.his.Iservice.IRulezgyService;
import com.heu.his.mapper.RulezgyMapper;
import com.heu.his.pojo.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-08-05 10:03
 */
@Service
public class RulezgyService implements IRulezgyService {

    @Autowired
    RulezgyMapper rulezgyMapper;

    @Override
    public int insertRule(int id, String ruleName, int deptid, int userid, String week) {
        return rulezgyMapper.insertRule(id,ruleName,deptid,userid,week);
    }

    @Override
    public int getRuleMaxID() {
        return rulezgyMapper.getRuleMaxID();
    }

    @Override
    public int deletesById(int[] arr) {
        return rulezgyMapper.deletesById(arr);
    }

    @Override
    public List<Rule> getRuleList(int deptno) {
        return rulezgyMapper.getRuleList(deptno);
    }
}
