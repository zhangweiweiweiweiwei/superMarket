package com.whpu.mapper;


import com.whpu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户mapper
 */
@Repository
public interface UserMapper {


//  根据用户名密码查找用户(登录  UserService访问)
    @Select("select * from smbms_user where userName =#{userName} and userPassword =#{userPassword}")
    public User findByMobileAndPwd(String userName, String userPassword);

//  查找所有用户
    @Select("select * from smbms_user")
    public List<User> findAll();

//  根据用户ID查找用户
    @Select("select * from smbms_user where id = #{id}")
    public User findById(Integer id);


//  根据用户名查找用户  判断用户是否已存在
    @Select("select * from smbms_user where userName = #{userName}")
    public User findByUserName(String userName);


//  添加用户
    @Insert("insert into smbms_user values(#{id},#{userCode},#{userName},#{userPassword},#{gender},#{birthday},#{phone},#{address},#{userType},#{createdBy},#{creationDate},#{modifyBy},#{modifyDate})")
    void save(User user);


//  删除用户
    @Delete("delete from smbms_user where id=#{id} ")
    void delete(Integer id);


//  修改用户
    @Update("update smbms_user set userName=#{userName},gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address},userType=#{userType},modifyBy=#{modifyBy},modifyDate=#{modifyDate} where id = #{id}")
    void update(User user);


//  更新密码
    @Update("update smbms_user set userPassword=#{userPassword} where id = #{id}")
    void updatePwd(String userPassword,Integer id);


//  模糊查询用户名
    @Select("select * from smbms_user where userName like concat('%',#{condition},'%')")
    List<User> findLike(String condition);
}
