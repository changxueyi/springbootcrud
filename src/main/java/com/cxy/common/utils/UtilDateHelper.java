package com.cxy.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 一些关于日期操作的公共方法
 *
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
    /**
     * 本地化为简体中文
     */
    public final static Locale DEFAULT_CHINA_LOCALE = Locale.SIMPLIFIED_CHINESE;
    /**
     * 时区设置为北京时间
     */
    public final static TimeZone DEFAULT_CHINA_TIMEZONE = TimeZone.getTimeZone("GMT+8:00");

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

    //测试Demo ,传入参数（"2020-8-18" "yyyy-MM-dd"),就会把字符转类型的，转换为Date类型的数据
    public static Date getDateFromStr(String formatDateStr, String formatter) {
        logger.debug("时间字符串转换成Date类型输出，参数为{}", formatDateStr);
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
            logger.error("日期类型转换错误，入参[{}]，不能转为{}格式的日期。", formatDateStr, formatter, e);
        }

        return date;
    }

    /**
     * <p>Title: getFormatDate</p>
     * <p>Description: Date 类型数据格式化为yyyy-MM-dd HH:mm:ss类型数据</p>
     *
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
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getFormatDate(Date date, String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_PATTERN;
        }
        if (date == null) {
            return "";
        } else {
            return new SimpleDateFormat(pattern).format(date);
        }
    }

    /**
     * <p>Title: getFormatDate</p>
     * <p>Description: Date 类型数据格式化为yyyy.MM.dd类型数据</p>
     *
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
        if (null == longDate) {
            return null;
        }
        Calendar c = Calendar.getInstance(UtilDateHelper.DEFAULT_CHINA_TIMEZONE, UtilDateHelper.DEFAULT_CHINA_LOCALE);
        c.setTimeInMillis(longDate);
        return c;
    }

    /**
     * 毫秒数转Date
     *
     * @param longDate
     * @return
     */
    public static Date getDateFromTimeInMillis(Long longDate) {
        if (null == longDate) {
            return null;
        }
        Calendar c = getCalendar(longDate);
        return c.getTime();
    }

    public static Long getTimeInMillisFromDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.getTime();
    }

    /**
     * 获得前一天：最后的时间时刻 例如： 今天2020 -11-6 19：57 得到的就是2020-11-5 23：59
     *
     * @param dataTime
     * @param amount
     * @return
     */
    public static Date getLastTimeOfAddDay(Date dataTime, Integer amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataTime);
        c.add(Calendar.DAY_OF_YEAR, amount);
        c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
        return c.getTime();
    }

    /**
     * 获得开始时间
     *
     * @param
     */
    public static Date getStartTimeOfMonth(Date dateTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        return c.getTime();
    }
    public enum DateFormatEnum {
        YYYYMMDD,
        HHMMSS
    }

    /**
     * 获取某个日期的当天开始时间
     *
     * @param d
     * @return
     */
    public static Date getStartTimeOfDay(Date d, Integer amount) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    private static class Constant {
        private final static String ERROR_MSG = "参数异常";
        private final static String STRING_YYYYMMDD = "0000-00-00";
        private final static String STRING_HHMMSS = "00:00:00";
        private final static String SPACE = " ";
    }

    /**
     * 获取时/分/秒格式化时间字符串
     *
     * @param d
     * @return
     */
    static public String getDateStrFormatHMS(Date d) {
        return getDateStrByFormat(d, DateFormatEnum.HHMMSS);
    }

    /**
     * 获取format格式化时间字符串
     * @param d
     * @param format
     * @return
     */
    static public String getDateStrByFormat(Date d, DateFormatEnum format) {
        SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Assert.isTrue(null != d && null != format, Constant.ERROR_MSG);
        return SIMPLE_DATE_FORMAT.format(d).split(Constant.SPACE).length == 0
                ? null
                : (DateFormatEnum.YYYYMMDD.equals(format)
                ? SIMPLE_DATE_FORMAT.format(d).split(Constant.SPACE)[0]
                : SIMPLE_DATE_FORMAT.format(d).split(Constant.SPACE)[1]);
    }




    public static void main(String[] args) {
        /**
         * 获取前一天最后时刻
         */
        Date result = getLastTimeOfAddDay(new Date(), -1);
        System.out.println(new SimpleDateFormat().format(result));

        //测试获取第二天的开始时间
        Date result1 = getStartTimeOfDay(result, 1);
        System.out.println(new SimpleDateFormat().format(result1));
    }

}
