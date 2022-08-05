package com.heu.his.Iservice;

import com.heu.his.pojo.Registlevel;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 17:01
 */
public interface IRegistlevelService {

    List<Registlevel> getRegistlevelList(String string);

    int updateRegistlevelById(Registlevel registlevel);

    int deleteRegistlevelById(int id);

    int getRegistlevelMaxId();

    int insertRegistlevel(Registlevel registlevel);

}
