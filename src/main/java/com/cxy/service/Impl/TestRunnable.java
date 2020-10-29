package com.cxy.service.Impl;

import com.cxy.dao.UserMapper;
import com.cxy.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName TestRunnable
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 15:55
 */
@Service
public class TestRunnable implements Runnable {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void run() {
        //System.out.println("常学奕");
       /* User user = new User();
        user.setId(12);
        user.setAge("JJ");
        user.setName("jj");
        user.setBirthday(new Date());
        int result = userMapper.insert(user);*/
        for (int i = 0; i < 10; i++) {
            System.out.println("i的值为"+i);
        }
    }
}