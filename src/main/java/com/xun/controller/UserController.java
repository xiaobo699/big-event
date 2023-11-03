package com.xun.controller;

import com.xun.pojo.Result;
import com.xun.pojo.User;
import com.xun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private Result register(String username,String password){

        //查询用户
        User user = userService.findByUsername(username);
        if(user == null ){
            //没有注册
            userService.register(username,password);
            return Result.success();
        }else{
            //用户名被占用
            return Result.error("用户名已经存在");
        }
    }
}
