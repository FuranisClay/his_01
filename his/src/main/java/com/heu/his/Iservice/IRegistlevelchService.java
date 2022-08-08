package com.heu.his.Iservice;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Registlevel;

public interface IRegistlevelchService {
    java.util.List<Registlevel> getRegistlevelname();
    int getreqistlevelmoney(int id);
}
