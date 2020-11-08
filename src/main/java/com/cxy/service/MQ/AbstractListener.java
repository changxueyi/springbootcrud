package com.cxy.service.MQ;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.List;

/**
 * @ClassName AbstractListener
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/5 16:53
 */
public abstract class AbstractListener implements MessageListener {


    public void onMessage(List<Message> list) throws Exception {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Message message : list) {
            String messageBody = message.toString();
            onMessage(messageBody);
        }
    }

    protected abstract void onMessage(String messageBody) throws Exception;


}