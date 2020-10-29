package com.cxy.controller;

import com.cxy.service.AsyncService;
import com.cxy.service.Impl.TestRunnable;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName AsyController
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 15:07
 */
@RestController
@RequestMapping("/asy")
public class AsyController {
    private static final Logger logger = LoggerFactory.getLogger(AsyController.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private TestRunnable testRunnable;
    @RequestMapping("/run")
    public String submit(){
        logger.debug("start submit");

        System.out.println("执行开始");
        //调用service层的任务
        asyncService.executeAsync();
        logger.debug("end submit");
        System.out.println("执行结束了");
        return "success";
    }

    @RequestMapping("/run1")
    public String submit1(){
        System.out.println("执行开始");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new TestRunnable());
        System.out.println("执行结束啊");
        //executorService.shutdown();
        return "aaa";
    }
}