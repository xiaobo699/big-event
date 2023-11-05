package com.xun.service.impl;

import com.xun.mapper.UserMapper;
import com.xun.pojo.User;
import com.xun.service.UserService;
import com.xun.utils.Md5Util;
import com.xun.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username,md5String);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> mp = ThreadLocalUtil.get();
        Integer id = (Integer) mp.get("id");
        userMapper.updateAvatarUrl(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        String newPd = Md5Util.getMD5String(newPwd);
        Map<String,Object> mp = ThreadLocalUtil.get();
        Integer id = (Integer) mp.get("id");
        userMapper.updatePwd(newPd,id);
    }
}
