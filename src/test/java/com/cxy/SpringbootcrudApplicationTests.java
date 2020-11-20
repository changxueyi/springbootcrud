package com.cxy;

import com.cxy.common.utils.SaleDateUtil;
import com.cxy.common.utils.UtilDateHelper;
import com.cxy.common.utils.UtilHelper;
import com.cxy.dao.UserMapper;
import com.cxy.domin.People;
import com.cxy.domin.User;
import com.cxy.service.UserService;
import com.cxy.service.schedule.SimpleJob;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.rmi.CORBA.Util;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringbootcrudApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(SpringbootcrudApplicationTests.class);
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
        user.setId(4);
        user.setAge("1");
        user.setName("京东数字科技_全渠道_门店4");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND,-3600);
        //user.setBirthday(c.getTime());
        //user.setBirthday(new Date());
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
        /**
         * CXY
         */
        System.out.println(result);
    }

    public static final String SALE_ORDER_EXTENDS = "btcs:o:ext:{0}:{1}";

    @Test
    public void test12() {
        //事务
        String key = new MessageFormat(SALE_ORDER_EXTENDS).format(new Object[]{"changxueyi", "liyanru"});
        System.out.println("key :" + key);
    }

    /**
     * 测试下：String的用法，contains
     */
    @Test
    public void test13() {
        String appCode = "15";
        String a = "|30|28|29|21|15|19|34|45|";
        Boolean result = a.contains("|" + appCode + "|");
        System.out.println(result);
    }

    /**
     * 测试 System.currentTimeMillis()
     */
    @Test
    public void test14() {
        Long result = System.currentTimeMillis();
        System.out.println(String.valueOf(result));
    }

    /**
     * 测试：
     */
    @Test
    public void test15() throws InterruptedException {
        System.out.println("TimeUnit.SECONDS.sleep start");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("TimeUnit.SECONDS.sleep end");
        //3秒转成毫秒
        System.out.println(TimeUnit.SECONDS.toMillis(3));
        //3分钟转成毫秒
        System.out.println(TimeUnit.MINUTES.toMillis(3));
        //3分钟转成秒
        System.out.println(TimeUnit.MINUTES.toSeconds(3));
        //3小时转成分钟
        System.out.println(TimeUnit.HOURS.toMinutes(3));
    }

    /**
     * 测试分布式锁
     */
    @Test
    public void test16() {
        //30 * 60 * 1000 = 1800 000
        String lockValue = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30L) + "";
        System.out.println(System.currentTimeMillis());//2020-11-07 22:28:05
        System.out.println(lockValue);//2020-11-07 22:58:05
    }

    /**
     * 测试数据类型的转换
     */
    @Test
    public void test17() throws Exception {
        //String转换为int类型
        String name = "11111";
        int newName = Integer.parseInt(name);
        //字符串转换成byte, short, int, float, double, long等数据类型，可以分别参考Byte, Short, Integer, Float, Double, Long类的parseXXX方法。
        Long newName1 = Long.parseLong(name);
        //数据类型准换为字符串
        int MyInt = 1234;
        String MyString = "" + MyInt;
        System.out.println(MyString);
        Long aa = 30L;
        String bb = String.valueOf(aa);
        System.out.println(bb);

        System.out.println("******************************************");
        long dateTime = 1604762579111L;
        Date date = new Date(dateTime);
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sformat.format(date));
    }

    @Test
    public void test18() {
        Long aa = 11L;
        String bb = String.valueOf(aa);
        System.out.println(bb);
        //常学奕
        Byte cc = 111;
        int dd = cc.byteValue();
        System.out.println(dd);
    }

    /**
     * 测试StringUtils.isNotBlank();
     */
    @Test
    public void test19() {
        String aa = null;
        System.out.println(StringUtils.isNotBlank(aa));
    }

    /**
     * 测试分库分表
     */
    @Test
    public void test20() {
        String tbIndex = String.format("_%04d", 1);
        System.out.println(tbIndex);
        tbIndex = String.format("_%04d", 11);
        System.out.println(tbIndex);
        tbIndex = String.format("_%04d", 111);
        System.out.println(tbIndex);
        tbIndex = String.format("_%04d", 1111);
        System.out.println(tbIndex);
    }

    /**
     * 测试日期
     */
    @Test
    public void test21() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date.getTime() + TimeUnit.MINUTES.toMillis(30L) + "");
        System.out.println(simpleDateFormat.format(date));
    }

    /**
     * 测试时间日期
     */
    @Test
    public void test22() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        /*calendar.add(Calendar.HOUR, -1);
        //calendar 得到的是date类型的日期，然后再次.getTime()，才可以得到时间戳
        System.out.println(calendar.getTime().getTime());*/

        calendar.add(Calendar.DATE, +1);
        System.out.println(calendar.getTime().getTime());
    }

    /**
     * 测试下：时间传递  - 8天，把其他的数据给查出来,测试成功
     */
    @Test
    public void test23() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -10);
        Map<Object, Object> map = new HashMap<>();
        map.put("endTime", calendar.getTime());
        System.out.println(calendar.getTime().getTime());
        List<User> result = userMapper.selectAll1(map);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    /**
     * 测试获得昨天的时间
     */
    @Test
    public void test24() {
        Date lastDate = UtilDateHelper.getLastTimeOfAddDay(new Date(), -1);
        Date firstDate = UtilDateHelper.getStartTimeOfDay(new Date(), -1);
        System.out.println(lastDate.getTime());//2020-11-07 23:59:59
        System.out.println(firstDate.getTime());//2020-11-07 00:00:00
    }

    /***
     * 测试getDateFromStr
     */
    @Test
    public void test25() {
        Date date = UtilDateHelper.getDateFromStr("2020-11-8 21:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.getTime());
    }

    /**
     * 测试下String 的Contect
     */
    @Test
    public void test26() {
        //String.concat
        String BT_USER_ACT_PROC = "CHAGNXUEYI";
        String BT_USER_ACT_POR = "LIYANRU";
        String result = BT_USER_ACT_PROC.concat("_").concat(BT_USER_ACT_POR);
        System.out.println(result);
    }

    /**
     * 我们会更好，我的代码能力会更好的，加油吧
     */
    @Test
    public void test27() {
        String[] keys = {"changxueyi", "liyanru", "liyanru1", "xiaobaobei"};

    }

    @Test
    public void diffDayCount() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date x = new Date();
        Date y = DateUtils.addDays(new Date(), 3);
        int res = SaleDateUtil.diffDayCount(x, y);
        logger.info("\n\r 请求 x={},y={} " +
                "\n\r 返回结果 res={}", f.format(x), f.format(y), res);
    }

    /**
     * 测试下：date.after(date)
     */
    @Test
    public void test28() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, -1);
        //String result = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30L) + "";
        Boolean aa = date.after(c.getTime());//2020-11-08 23:04:38
        System.out.println(date.getTime());//2020-11-08 22:04:38
        System.out.println(c.getTime().getTime());
        System.out.println("***********");
        System.out.println(aa);
    }

    /**
     * 自己写的日期工具类
     */
    @Test
    public void test29() {
        Date date = new Date();
        Long result = date.getTime();
        System.out.println(result);
    }

    /**
     * 测试excel
     */
    @Test
    public void test30() {
        return;
    }


}
