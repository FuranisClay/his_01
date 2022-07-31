package com.heu.his.mapper;

import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RegisterMapper {

    /**
     * 查询挂号患者信息
     * @param rn  患者姓名
     * @return
     */
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "registlevel",column = "RegistLeID",
                    one = @One(select = "com.heu.his.mapper.RegistlevelMapper.getRegistlevelByIdOne"))
    })
    @Select("<script>select * from register where 1=1 " +
            "<if test=\"rn!=null and rn!=''\">and RealName like concat('%',#{rn},'%')</if>" +
            "</script>")
    java.util.List<Register> getRegisterListAndRL(
            @Param(value = "rn") String rn);

    /**
     * 一对多  根据挂号编号查询改编号下的多有患者
     * @param ReLeId 挂号类型编号
     * @return 返回某个类型下的所有患者
     */
    @Select("select * from register where RegistLeID=#{ReLeId}")
    java.util.List<Register> getRegistListByRL(int ReLeId);

    /**
     * 多对一  查询挂号患者的挂号编号
     * @param rn  患者姓名
     * @param rli  患者编号
     * @return
     */
    @Select("<script>select * from register where 1=1 " +
            "<if test=\"rn!=null and rn!=''\">and RealName like concat('%',#{rn},'%')</if>" +
            "<if test=\"rli>0\">and RegistLeID=#{rli}</if>" +
            "</script>")
    java.util.List<Register> getRegisterList(
            @Param(value = "rn") String rn, @Param(value = "rli") int rli);
}
