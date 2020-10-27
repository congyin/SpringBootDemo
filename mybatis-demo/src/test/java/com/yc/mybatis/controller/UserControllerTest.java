package com.yc.mybatis.controller;



import com.jayway.jsonpath.JsonPath;
import com.yc.mybatis.MybatisDemoApplication;
import com.yc.mybatis.model.User;
import com.yc.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MybatisDemoApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
public class UserControllerTest {

    private MockMvc mockMvc;


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    /**
     * 测试获取所有
     * @throws Exception
     */
    @Test
    public void testGetAllUser() throws Exception{
        mockMvc.perform(get("/user/list")
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(0)));


    }

    /**
     * 测试getUserDetail
     * @throws Exception
     */
    @Test
    public void testGetUserDetail() throws Exception{
        User user = new User(1L, "测试", "13312341234","test@163.com");
        when(userService.findById(1L)).thenReturn(user);

        mockMvc.perform(get("/user/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.data.id", is(1)))
                .andExpect(jsonPath("$.data.name", is("测试")));

        verify(userService, times(1)).findById(1L);
        verifyNoMoreInteractions(userService);
    }


    /**
     * 测试 创造用户
     * @throws Exception
     */
    @Test
    public void testCreateUser() throws Exception {

        mockMvc.perform(get("/user/add")
                .param("id", "1")
                .param("name", "测试"))
                .andExpect(status().isOk());

    }

    /**
     * 测试删除
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception{
        User user = User.builder().id(1L).name("该用户会被删除").build();

        mockMvc.perform(delete("/user/{id}", user.getId()))
                .andExpect(status().isOk());
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