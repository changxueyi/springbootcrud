package com.cxy.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 13:47
 */
public class DateUtils {
    //时间戳转Date
    public static String dateForDate(Long time) {
        //// 10位的秒级别的时间戳
        String results = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        return results;
    }

    public static void main(String[] args) throws ParseException {
        long time1 = 1603869528;
        String result = dateForDate(time1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date udate = sdf.parse(result);

        System.out.println(result.toString());
    }




}