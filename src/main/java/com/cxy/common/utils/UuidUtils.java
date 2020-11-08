package com.cxy.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UuidUtils
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/8 21:40
 */
public class UuidUtils {
    private static final Logger logger = LoggerFactory.getLogger(UuidUtils.class);
    public String genUuid() {
        try {
            Calendar cal = Calendar.getInstance();
            int uuid_year = cal.get(Calendar.YEAR) - 2016; //减去上线日年份
            int uuid_week = cal.get(Calendar.WEEK_OF_YEAR);
            int uuid_day = cal.get(Calendar.DAY_OF_WEEK);
            int uuid_hour = cal.get(Calendar.HOUR_OF_DAY);
            StringBuilder uuidStr = new StringBuilder();
            uuidStr.append(uuid_year);
            uuidStr.append(String.format("%02d", uuid_hour));
            uuidStr.append(String.format("%02d", uuid_week));
            uuidStr.append(uuid_day);
            String uuid_key = "sale_uuid_incr_sequence_" + uuidStr.toString();
            //Long incr = cacheService.incr(uuid_key, 2, TimeUnit.DAYS);
            //assert incr < 100;
            //uuidStr.append(String.format("%02d", incr));
            uuidStr.append(new Random().nextInt(9));
            return uuidStr.toString();
        } catch (Exception e) {
            logger.error("生成UUID失败。", e);
            throw new RuntimeException(e);
        }
    }
}