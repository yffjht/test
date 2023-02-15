package com.example.de;

import com.example.de.mapper.UserMapper;
import com.example.de.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
class DeApplicationTests {
    @Autowired(required = false)
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void testMPMapper(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
