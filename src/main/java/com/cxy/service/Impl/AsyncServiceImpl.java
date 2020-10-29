package com.cxy.service.Impl;

import com.cxy.common.Executor.ExecutorConfig;
import com.cxy.service.AsyncService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName AsyncServiceImpl
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 15:06
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    /**
     * 执行异步任务
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.debug("start executeAsync");
        try{
            //Thread.sleep(1000);asyncServiceExecutor
            for (int i = 0;i<10;i++){
                System.out.println("打印：第几遍"+i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.debug("end executeAsync");
    }
}