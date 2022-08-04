package com.heu.his.Iservice;

import com.heu.his.pojo.Fmeditem;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-27 15:01
 */
public interface IFmeditemzgyService {

    List<Fmeditem> getFmeditemList(String string);

    int getFmeditemMaxId();

    int deleteFmeditemById(int id);

    int updateFmeditemById(Fmeditem fmeditem);

    int insertFmeditem(Fmeditem fmeditem);

}
