package com.cxy.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 一些关于日期操作的公共方法
 * @author liufenglei
 * @date 2018年8月1日 上午9:09:47
 **/
public class UtilDateHelper {

    public UtilDateHelper() {
    }

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(UtilDateHelper.class);
    /**  本地化为简体中文  */
    public final static Locale DEFAULT_CHINA_LOCALE = Locale.SIMPLIFIED_CHINESE;
    /**  时区设置为北京时间  */
    public final static TimeZone DEFAULT_CHINA_TIMEZONE = TimeZone.getTimeZone("GMT+8:00");

    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public final static String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public final static String DEFAULT_DATETIME_PATTERN = DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;


    /**
     *
     * <p>Title: getCurrentDate</p>
     * <p>Description: 时间字符串转换成Date类型输出</p>
     * @return
     * @throws ParseException
     */

    //测试Demo ,传入参数（"2020-8-18" "yyyy-MM-dd"),就会把字符转类型的，转换为Date类型的数据
    public static Date getDateFromStr(String formatDateStr, String formatter) {
        logger.debug("时间字符串转换成Date类型输出，参数为{}", formatDateStr);
        //
        if (null == formatDateStr || "".equals(formatDateStr)) {
            return null;
        }
        if(null == formatter || "".equals(formatter)) {
            formatter = DEFAULT_DATETIME_PATTERN;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat(formatter).parse(formatDateStr);
        } catch (ParseException e) {
            logger.error("日期类型转换错误，入参[{}]，不能转为{}格式的日期。", formatDateStr, formatter, e);
        }

        return date;
    }

    /**
     *
     * <p>Title: getFormatDate</p>
     * <p>Description: Date 类型数据格式化为yyyy-MM-dd HH:mm:ss类型数据</p>
     * @param date
     * @return
     */
    public static String getFormatDateYMDHMS(Date date) {
        if (date == null) {
            return "";
        } else {
            return new SimpleDateFormat(DEFAULT_DATETIME_PATTERN).format(date);
        }
    }

    /**
     * format date
     * @param date
     * @param pattern
     * @return
     */
    public static String getFormatDate(Date date, String pattern) {
        if(null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_PATTERN;
        }
        if(date == null) {
            return "";
        } else {
            return new SimpleDateFormat(pattern).format(date);
        }
    }

    /**
     *
     * <p>Title: getFormatDate</p>
     * <p>Description: Date 类型数据格式化为yyyy.MM.dd类型数据</p>
     * @param date
     * @return
     */
    public static String getFormatDateYMD(Date date) {
        if (date == null) {
            return "";
        } else {
            return new SimpleDateFormat(DEFAULT_DATE_PATTERN).format(date);
        }
    }

    /**
     * 功能: 获得本地化的时间
     *
     * @param longDate 时间的长整数
     * @return
     */
    public static Calendar getCalendar(Long longDate) {
        if(null == longDate) {
            return null;
        }
        Calendar c = Calendar.getInstance(UtilDateHelper.DEFAULT_CHINA_TIMEZONE, UtilDateHelper.DEFAULT_CHINA_LOCALE);
        c.setTimeInMillis(longDate);
        return c;
    }

    /**
     * 毫秒数转Date
     * @param longDate
     * @return
     */
    public static Date getDateFromTimeInMillis(Long longDate) {
        if(null == longDate) {
            return null;
        }
        Calendar c = getCalendar(longDate);
        return c.getTime();
    }

    public static Long getTimeInMillisFromDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.getTime();
    }

}
