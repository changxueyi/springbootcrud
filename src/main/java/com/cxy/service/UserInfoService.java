package com.cxy.service;

import com.cxy.domin.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserInfoService {
    List<User> getAll(int pageNo,int pageSize);

    PageInfo<User> getAllInfo(int pageNo, int pageSize);
}
