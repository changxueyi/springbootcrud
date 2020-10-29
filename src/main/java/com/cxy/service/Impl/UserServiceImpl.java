package com.cxy.service.Impl;

import com.cxy.dao.UserMapper;
import com.cxy.domin.User;
import com.cxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/27 21:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(Integer id) {
        return userMapper.selectId(id);
    }
}