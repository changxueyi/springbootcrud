package com.cxy.controller;

import com.cxy.domin.User;
import com.cxy.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName PageTestController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 17:34
 */
@RestController
@RequestMapping("/page")
public class PageTestController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 跳转到应用列表页面
     *
     * @param pageNo   要显示第几页内容
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<User> list(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {
        PageInfo<User> page = userInfoService.getAllInfo(pageNo, pageSize);
        return page;
    }

    //返回的不用再使用PageInfo进行处理了，原始的数据
    @RequestMapping("/list1")
    @ResponseBody
    public List<User> list1(int pageNo, int pageSize) {
        return userInfoService.getAll(pageNo,pageSize);
    }

    @RequestMapping("/list2")
    @ResponseBody
    public List<User> list2(int pageNo, int pageSize) {
        Page<User> pageList = (Page<User>) userInfoService.getAll(pageNo,pageSize);
        return pageList;
    }
}