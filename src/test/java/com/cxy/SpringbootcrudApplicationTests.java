package com.cxy;

import com.cxy.dao.UserMapper;
import com.cxy.domin.PageReq;
import com.cxy.domin.People;
import com.cxy.domin.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringbootcrudApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
        System.out.println("恭喜你，运行成功了");
    }

    @Test
    public void test1() {
        User user = new User();
        user.setId(3);
        user.setName("test1");
        user.setAge("21");
        user.setBirthday(new Date());
        Integer result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void test02() {
        User user = userMapper.selectId(5);
        System.out.println("1111111111");
        System.out.println(user.toString());
    }

    @Test
    public void test03() {
        User user = new User();
        user.setAge("22");
        user.setName("tetst1");
        user.setBirthday(new Date());
        Integer result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void test04() {
        List<User> result = userMapper.selectAll();
        System.out.println(result.toString());
    }

    @Test
    public void test05() {
        User user = new User();
        People people = new People();
        people.setId(1);
        people.setAge("22");
        people.setSex("男");
        BeanUtils.copyProperties(people,user);
        System.out.println(user.toString());
    }

}
