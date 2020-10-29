package com.cxy.service.Impl;

import com.cxy.dao.UserMapper;
import com.cxy.domin.User;
import com.cxy.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 17:35
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAll(int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.selectAll();
    }

    @Override
    public PageInfo<User> getAllInfo(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}