package com.cxy.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 13:47
 */
public class DateUtils {
    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public final static String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public final static String DEFAULT_DATETIME_PATTERN = DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;
    /**
     * <p>Title: getCurrentDate</p>
     * <p>Description: 时间字符串转换成Date类型输出</p>
     *
     * @return
     * @throws ParseException
     */
    public static Date getDateFromStr(String formatDateStr, String formatter) {
        //logger.debug("时间字符串转换成Date类型输出，参数为{}", formatDateStr);
        //
        if (null == formatDateStr || "".equals(formatDateStr)) {
            return null;
        }
        if (null == formatter || "".equals(formatter)) {
            formatter = DEFAULT_DATETIME_PATTERN;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat(formatter).parse(formatDateStr);
        } catch (ParseException e) {
           // logger.error("日期类型转换错误，入参[{}]，不能转为{}格式的日期。", formatDateStr, formatter, e);
        }

        return date;
    }
    //时间戳转Date
    public static String dateForDate(Long time) {
        //// 10位的秒级别的时间戳
        String results = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        return results;
    }

    public static Long fun1(long timeout, TimeUnit timeUnit) {
        long result = System.currentTimeMillis() + timeUnit.toMillis(timeout);
        return result;
    }

    public static Date fun2() {
        return new Date(System.currentTimeMillis() + 10000);
    }

    public static String fun3() {
        Date date = new Date(1604373812);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        //return new Date(System.currentTimeMillis());
        return "aaa";
    }

    public static void main(String[] args) throws ParseException {
        //测试dateForDate
       /* long time1 = 1603869528;
        String result = dateForDate(time1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date udate = sdf.parse(result);

        System.out.println(result.toString());*/
        //测试fun1
       /* Long re = fun1(10, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis());//2020-11-03 09:53:34
        System.out.println(re);//2020-11-03 09:53:44*/
        //测试fun2
        /*System.out.println(System.currentTimeMillis());
        System.out.println(fun2());*/
        //测试fun3
        //System.out.println(fun3());
        String reachTime = "2020-11-5";
        Date result = UtilDateHelper.getDateFromStr(reachTime, "yyyy-MM-dd");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(result));

    }


}