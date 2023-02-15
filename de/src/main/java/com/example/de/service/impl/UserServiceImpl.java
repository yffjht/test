package com.example.de.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.de.mapper.UserMapper;
import com.example.de.pojo.User;
import com.example.de.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {
    @Resource
    UserMapper userMapper;

    public List<User> queryAllUser(){
        return userMapper.selectAllUser();
    }
}
