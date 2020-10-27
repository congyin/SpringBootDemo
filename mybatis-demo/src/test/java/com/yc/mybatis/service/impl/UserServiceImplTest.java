package com.yc.mybatis.service.impl;

import com.yc.mybatis.dao.UserMapper;
import com.yc.mybatis.model.User;
import com.yc.mybatis.service.UserService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void findById() {
        User byId = userService.findById(1L);
        System.out.println(byId);
    }

    @Test
    void findAll() {
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    void save() {
        userService.save(createUser());
    }

    @Test
    void delete() {
        userService.delete(3l);
    }

    private User createUser(){
        User user = User.builder()
                .id(1L)
                .name("测试")
                .mobile("13312341234")
                .email("test@163.com")
                .build();
        return user;
    }
}