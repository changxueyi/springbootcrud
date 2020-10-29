package com.cxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxy.common.cache.CacheUtil;
import com.cxy.common.utils.RedisUtil;
import com.cxy.domin.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisTestController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 23:12
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/test")
    public String test() {
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("age", "22");
        return "ok";
    }

    @GetMapping("/testAll")
    public String test1() {
        People people = new People();
        people.setId(1);
        people.setAge("22");
        people.setSex("男");
        String cacheKey = CacheUtil.messageFormat(CacheUtil.CacheKey.VALID_SCORE, "积分", "常学奕");
        redisUtil.set(cacheKey, "100积分", CacheUtil.getCacheTime(CacheUtil.CacheTimeIndex.MINUTE));
       // redisUtil.get(cacheKey);
        //redisUtil.set("didi","恭喜您，常学奕，您通过了滴滴面试");
        return "ok";
    }

    @GetMapping("/testGet")
    public String test2() {
        String cacheKey = CacheUtil.messageFormat(CacheUtil.CacheKey.VALID_SCORE, "积分", "李艳茹");
        String result = (String) redisUtil.get(cacheKey);
        People people = JSONObject.parseObject((String)redisUtil.get(cacheKey),People.class);
        System.out.println(redisUtil.get(cacheKey));
        System.out.println(people.toString());
        return "ok";
    }

    @GetMapping("/test03")
    public String test3() {
        People people = new People();
        people.setId(1);
        people.setAge("22");
        people.setSex("男");
        String cacheKey = CacheUtil.messageFormat(CacheUtil.CacheKey.VALID_SCORE, "积分", "李艳茹");
        redisUtil.set(cacheKey, JSONObject.toJSONString(people), CacheUtil.getCacheTime(CacheUtil.CacheTimeIndex.MINUTE));
        return "ok";
    }


}