package com.example.test.mapper;

public interface UserMapper {
    //查询余额
    Double selectUserMoney(Integer id);
    //用户消费/退款方法
    int updateUser(Integer id,Double money);

}
