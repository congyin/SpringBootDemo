package com.yc.mybatis.controller;

import com.yc.mybatis.model.Result;
import com.yc.mybatis.model.User;
import com.yc.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("list")
    public Result getAllUser() {

        Result result = null;
        try {
            List<User> users = userService.findAll();
            result = Result.ok("查询成功").put("data",users);
        } catch (Exception ex) {
            result = Result.error(-1,"查询失败");
            logger.error(ex.getMessage(), ex);
        } finally {
        }

        return result;
    }

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getUserDetail(@PathVariable("id") Long id) {
        Result result = null;
        try {
            User user = userService.findById(id);
            result = Result.ok("查询成功").put("data",user);
        } catch (Exception ex) {
            result = Result.error(-1,"查询失败");
            logger.error(ex.getMessage(), ex);
        } finally {
        }

        return result;
    }

    /**
     * 添加用户
     * @param id
     * @param name
     * @param mobile
     * @param email
     * @return
     */
    @GetMapping("/add")
    public Result createUser(@RequestParam(value = "id",required = false) Long id,
                             @RequestParam(value = "name",required = true) String name,
                             @RequestParam(value = "mobile",required = false) String mobile,
                             @RequestParam(value = "email",required = false) String email){
        Result result = null;
        try {
            User user = User.builder()
                    .id(id)
                    .name(name)
                    .mobile(mobile)
                    .email(email)
                    .build();
            userService.save(user);
            result = Result.ok("保存成功").put("data",user);
        } catch (Exception ex) {
            result = Result.error(-1,"保存失败");
            logger.error(ex.getMessage(), ex);
        } finally {
        }

        return result;

    }


    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable("id") Long id) {
        Result result = null;
        try {
            userService.delete(id);
            result = Result.ok("删除成功");
        } catch (Exception ex) {
            result = Result.error(-1,"删除失败");
            logger.error(ex.getMessage(), ex);
        } finally {
        }

        return result;
    }


}
