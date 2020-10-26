package com.yc.mybatis.dao;


import com.yc.mybatis.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Long id);

    /**
     * 查找所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(name, mobile, email) values(#{name}, #{mobile}, #{email})")
    void save(User user);


    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(Long id);
}
