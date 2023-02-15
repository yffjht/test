package com.example.de.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.de.Json.JsonResult;
import com.example.de.pojo.User;
import com.example.de.service.UserService;
import com.example.de.service.impl.UserServiceImpl;
import com.example.de.util.FinalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getAllUser")
    public JsonResult<List<User>> getAllUser(){
        List<User> userList = userService.queryAllUser();
        return new JsonResult<>(FinalDate.JSON_CODE,userList);
    }
//   新增和修改
    @RequestMapping("/save")
    public boolean save(User user){
        return userService.saveOrUpdate(user);
    }
//    删除
    @RequestMapping("/delete/{id}")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }

    @RequestMapping("/page")
    public IPage<User> userPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String username,
                               @RequestParam(defaultValue = "") String email){
        System.out.println(pageNum+"---"+pageSize);
        IPage<User> page = new Page<>(pageNum,pageSize);
//        条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("name",username);
        }
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        return userService.page(page,queryWrapper);
    }
}
