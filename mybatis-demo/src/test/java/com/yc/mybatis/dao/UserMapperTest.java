package com.yc.mybatis.dao;

import com.yc.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findById() {
        User user = userMapper.findById(2L);
        System.out.println(user);
    }

    @Test
    void findAll() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

    @Test
    void save() {
        User user = User.builder()
                .name("张三")
                .mobile("18888888888")
                .email("zz@test.cn")
                .build();
        userMapper.save(user);
    }

    @Test
    void delete() {
    }
}