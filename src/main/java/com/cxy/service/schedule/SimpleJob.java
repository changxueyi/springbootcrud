package com.cxy.service.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ClassName SimpleJob
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 22:35
 */
@Slf4j
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //创建工作详情
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //获取工作的名称
        String name = jobDetail.getKey().getName();//任务名
        String group = jobDetail.getKey().getGroup(); //任务group
        String job = jobDetail.getJobDataMap().getString("data");//任务中的数据
        System.out.println("*****************常学奕*********************");
        System.out.println("job执行:" + name + "group" + group + "data" + job + new Date());
        //log.info("job execute---" + new Date());
    }

}