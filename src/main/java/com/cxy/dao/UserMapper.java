package com.cxy.dao;

import com.cxy.domin.PageReq;
import com.cxy.domin.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/27 19:41
 */
public interface UserMapper {
    int insert(User user);

    int insert2(User user);

    User selectId(Integer id);


    int delete(Integer id);

    List<User> selectAll();
}