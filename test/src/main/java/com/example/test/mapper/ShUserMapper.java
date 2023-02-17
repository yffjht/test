package com.example.test.mapper;


import java.util.List;

public interface ShUserMapper {
    //用户金额调用详情方法
    int insertShUserByDetail(Integer uid, String detail);
    //查询用户金额变动明细的接口
    List<String> selectUserMoneyByDetail(Integer uid);
}
