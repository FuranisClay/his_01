package com.heu.his.Iservice;

import com.heu.his.pojo.Drugs;
import org.apache.ibatis.annotations.Param;

/**
 * @author legend
 * @create 2022-07-30-15:35
 */
public interface IDrugsService {
    java.util.List<Drugs> getDrugsList(@Param("drugsName") String drugsName, @Param("id") int id);
    int deleteById(int id);
    int insertDrugs(Drugs drugs);
}
