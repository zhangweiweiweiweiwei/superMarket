package com.whpu.service.impl;

import com.whpu.mapper.UserMapper;
import com.whpu.pojo.User;
import com.whpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //定义userMapper对象
    @Autowired
    private UserMapper userMapper;


    //获取所有用户信息
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


    //从FrameController的登录方法访问，获取参数后访问userMapper的findByMobileAndPwd方法
    @Override
    public User findByMobileAndPwd(String userName, String userPassword) {
        return userMapper.findByMobileAndPwd(userName,userPassword);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }


    //判断用户是否已存在
    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    //新增用户
    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    //删除用户
    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    //更新用户
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    //模糊查询
    @Override
    public List<User> findLike(String condition) {
        return userMapper.findLike(condition);
    }

    //更新密码
    @Override
    public void updatePwd(String userPassword, Integer id) {
        userMapper.updatePwd(userPassword,id);
    }

}
