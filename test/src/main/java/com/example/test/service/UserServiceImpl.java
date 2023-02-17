package com.example.test.service;

import com.example.test.mapper.ShUserMapper;
import com.example.test.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional//开启事务
public class UserServiceImpl {
    @Resource
    UserMapper userMapper;
    @Resource
    ShUserMapper shUserMapper;

    /**
     * 查询用户余额
     * @param id
     */
    public Double queryUserMoney(Integer id){
        return userMapper.selectUserMoney(id);
    }

    /**
     * 用户消费方法
     * @param id 消费用户id
     * @param m 消费金额
     */
    public boolean saveUser(Integer id,Double m){
        boolean b =false;
        //查询用户余额
        Double money = userMapper.selectUserMoney(id);
        //消费
        if(money >= m){
            money-=m;
            int num = userMapper.updateUser(id,money);
            if(num==1){
                //		添加消费记录
                String massage = "用户在购买了xxx商品，消费："+m+"元";
                shUserMapper.insertShUserByDetail(id,massage);
                b = true;
            }else{
                System.out.println("消费时发生异常");
            }

        }else{
            System.out.println("余额不足...");
        }
        return  b;

    }
    /**
     * 用户退款方法
     * @param id 用户id
     * @param m 退款金额
     */
    public boolean saveUserByt(Integer id,Double m){
        boolean b = false;
        //查询用户余额
        Double money = userMapper.selectUserMoney(id);
        //退款
            money+=m;
            int num = userMapper.updateUser(id,money);
            if(num==1){
                //		添加退款记录
                String massage = "用户退回了xxx商品，退款："+m+"元";
                shUserMapper.insertShUserByDetail(id,massage);
                b = true;
            }else{
                System.out.println("消费时发生异常");
            }
         return b;
    }
    /**
     * 查询用户余额
     * @param id
     */
    public List<String> queryUserMoneyByDetail(Integer id){
        return  shUserMapper.selectUserMoneyByDetail(id);
    }
}
