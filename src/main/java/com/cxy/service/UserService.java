package com.cxy.service;

import com.cxy.domin.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/27 21:08
 */
public interface UserService {
    User getUser(Integer id);
    int insert(User user);
}