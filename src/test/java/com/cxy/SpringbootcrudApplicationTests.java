package com.cxy;

import com.cxy.dao.UserMapper;
import com.cxy.domin.People;
import com.cxy.domin.User;
import com.cxy.service.UserService;
import com.cxy.service.schedule.SimpleJob;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringbootcrudApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private UserService userService;


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
        user.setId(12);
        user.setAge("1");
        user.setName("京东数字科技");
        Calendar c = Calendar.getInstance();
        //c.add(Calendar.SECOND,-3600);
        user.setBirthday(c.getTime());
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
        BeanUtils.copyProperties(people, user);
        System.out.println(user.toString());
    }

    /**
     * 测试成功
     *
     * @throws SchedulerException
     * @throws InterruptedException
     */
    @Test
    public void test6() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //定义一个Trigger ，触发条件类
        Trigger trigger = TriggerBuilder.newTrigger()
                //创建触发器,trigger
                .withIdentity("trigger1", "group1")
                .startNow() //一旦加入schedule ，立即生效,即开始时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        // 2秒执行1次，共重复一次.withIntervalInSeconds(2).withRepeatCount(1))
                        .withIntervalInSeconds(2).repeatForever())
                //.endAt(new Date(System.currentTimeMillis()+10*1000)) // 10s后停止
                //.endAt(new GregorianCalendar(2020,10,29,23,39,10).getTime())
                .build();
        //withRepeatCount 循环几次
        //withIntervalInSeconds 多少秒一次
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job04", "group04")
                .usingJobData("data", "hello word")
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        //关闭调度器
        Thread.sleep(10000);
        scheduler.shutdown();
    }

    @Test
    public void test7() {
        Map<String, Object> map = new HashMap<>();
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println("********************");
        c.add(Calendar.SECOND, -3600);
        map.put("endTime", c.getTime());
        System.out.println(map.get("endTime").toString());
    }

    @Test
    public void test8() {
        Integer result = userMapper.delete(7);
        System.out.println(result);
    }

    /**
     * 测试分库分表的后缀信息
     */
    @Test
    public void test09() {
        //0 ->_0000
        //1 ->_0001
        int idx = 1;
        //第一个的bai4表示右对齐且占4个字符位置，0表示空位补du0；
        String tbIndex = String.format("_%04d", idx);
        System.out.println(tbIndex);
    }

    @Test
    public void test10() {
        User user = new User();
        user.setName("京东物流");
        //     user.setId(15);
        user.setBirthday(new Date());
        user.setAge("11");
        Integer result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void test11() {
        //事务的测试,下面的语句会打印空指针
       /* String result = null;
        System.out.println(result.toString());*/

        //测试的代码中，插入可口可乐执行成功，但是后面的打印失败，所以整体回滚
        User user = new User();
        user.setAge("123");
        user.setBirthday(new Date());
        user.setName("可口可乐");
        Integer result = userService.insert(user);
        System.out.println(result);


    }


}
