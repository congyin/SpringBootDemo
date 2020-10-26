package com.yc.mybatis.service;

import com.yc.mybatis.model.User;

import java.util.List;

public interface UserService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 查找所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据id删除
     * @param id
     */
    void delete(Long id);

}
