package com.heu.his.mapper;
/**
 * author:Hulake
 * time:2022/8/3
 */

import com.heu.his.pojo.Settlecategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SettlecategoryChMapper {

    /**
     * author:Hulake
     * 查询患者的支付方式
     * @param sid
     * @return
     */
    @Select("select * from settlecategory where ID=#{sid}")
    java.util.List<Settlecategory> getsettlecategoryid(int sid);

    /**
     * author:Hulake
     * 查询患者可用的所有支付方式
     * @return
     */
    @Select("select * from settlecategory")
    java.util.List<Settlecategory> getsettlecategoryname();
}
