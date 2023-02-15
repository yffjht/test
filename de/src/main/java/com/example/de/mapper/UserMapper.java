package com.example.de.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.de.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllUser();
}
