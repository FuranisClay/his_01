package com.heu.his.mapper;

import com.heu.his.pojo.Department;
import com.heu.his.pojo.Registlevel;
import com.heu.his.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhougy
 * @create 2022-07-20 14:37
 */
@Mapper
public interface UserzgyMapper {

    @Update("update user set DelMark=0 where ID=#{id}")
    int deleteUserById(int id);

    @Update("update user set UserName=#{userName}," +
            "Password=#{password},RealName=#{realName},UseType=#{useType}," +
            "DocTitleID=#{docTitleId},DeptID=#{deptId},RegistLeID=#{registLeId}" +
            ",IsScheduling=#{isScheduling}" +
            " where ID=#{id}")
    int updateUserById(User user);

    @Select("select * from user where UserName=#{ename} and Password=#{pwd}")
    User validate(String ename, String pwd);

    @Results({
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "deptId", column = "DeptID"),
            @Result(property = "department", column = "DeptID", one = @One(select = "com.heu.his.mapper.DepartmentzgyMapper.getDepartmentById")),
            @Result(property = "docTitleId", column = "DocTitleID"),
            @Result(property = "constantitem", column = "DocTitleID", one = @One(select = "com.heu.his.mapper.ConstantItemzgyMapper.getConstantItemByID")),
            @Result(property = "registLeId", column = "RegistLeID"),
            @Result(property = "registlevel", column = "RegistLeID", one = @One(select = "com.heu.his.mapper.RegistlevelzgyMapper.getRegistlevelById"))
    })
    @Select("<script>select * from user where 1=1 and DelMark = 1 " +
            "<if test=\"name!=null and name != ''\">and RealName like concat('%',#{name},'%')</if>" +
            "</script>")
    List<User> getUserList(String name);

    @Select("select * from user where DeptID = #{deptno}")
    List<User> getUserListByDeptno(int deptno);

    @Select("select * from user where ID=#{id}")
    User getUserByID(int id);

//    @Select("<script>select * from user where 1=1" +
//            "<if test=\"name!=null and name != ''\">and UserName=#{name}</if>" +
//            "<if test=\"id>0\">and ID=#{id}</if>" +
//            "</script>")
//    java.util.List<User> getUserList(String name,Integer id);

//    @Insert("insert into user(ID, UserName, Password, RealName, UseType, DocTitleID, IsScheduling, DeptID, RegistLeID, DelMark) values" +
//            " (#{id},#{userName},#{password},#{realName},#{useType},#{docTitleId},#{isScheduling},#{deptId},#{registLeId},#{delMark})")
//    int insertUser(User user);

    @Update("<script>update User set delmark=1 where id in" +
            "<foreach collection=\"array\" item=\"eno\" open=\"(\" close=\")\" separator=\",\">" +
            "#{eno}</foreach>" +
            "</script>")
    int deletesById(int[] arr);

    @Select("select ID from user where DelMark =1 order by ID desc limit 1")
    int getUserMaxID();

    @Insert("insert into user (ID,UserName,Password,RealName,UseType," +
            "DocTitleID,IsScheduling,DeptID,RegistLeID,DelMark) " +
            "values (#{id},#{userName},#{password},#{realName},#{useType}," +
            "#{docTitleId},#{isScheduling},#{deptId},#{registLeId}" +
            ",1)")
    int insertUser(User user);

}
