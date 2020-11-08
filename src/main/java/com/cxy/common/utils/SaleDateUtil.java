package com.cxy.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by fuzhengwei1 on 2018/6/8.
 * added by guanjian on 2018/11/09 增加时间比较、拼接方法
 */

public class SaleDateUtil {
    private final static Logger logger = LoggerFactory.getLogger(SaleDateUtil.class);

    public enum DateFormatEnum {
        YYYYMMDD,
        HHMMSS
    }

    private static class Constant {
        private final static String ERROR_MSG = "参数异常";
        private final static String STRING_YYYYMMDD = "0000-00-00";
        private final static String STRING_HHMMSS = "00:00:00";
        private final static String SPACE = " ";
    }

    /**
     * 计算日期间隔天数
     *
     * @param x 减数日期
     * @param y 被减数日期
     * @return 间隔天数
     */
    static public int diffDayCount(Date x, Date y) {
        int dayCount = (int) ((x.getTime() - y.getTime()) / (24 * 60 * 60 * 1000));
        return dayCount < 0 ? 0 : dayCount;
    }

    /**
     * 计算日期间隔集合
     *
     * @param x 起始日期
     * @param y 结束日期
     * @return 日期集合
     */
    static public List<Date> diffDayList(Date x, Date y) {
        List<Date> dateList = new ArrayList<Date>();
        Date site = x;
        dateList.add(site);
        while (site.before(y)) {
            Calendar c = Calendar.getInstance();
            c.setTime(site);
            c.add(Calendar.DAY_OF_MONTH, 1);
            site = c.getTime();
            dateList.add(site);
        }
        return dateList;
    }

    /**
     * 比较两个时间年/月/日
     *
     * @param x
     * @param y
     * @return
     */
    static public Integer compareDateFormatYMD(Date x, Date y) {
        return compare(x, y, DateFormatEnum.YYYYMMDD);
    }

    /**
     * 比较两个时间时/分/秒
     *
     * @param x
     * @param y
     * @return
     */
    static public Integer compareDateFormatHMS(Date x, Date y) {
        return compare(x, y, DateFormatEnum.HHMMSS);
    }

    /**
     * 比较两个时间
     *
     * @param x
     * @param y
     * @param format
     * @return
     */
    static public Integer compare(Date x, Date y, DateFormatEnum format) {
        String xStr, yStr;
        Date xDate = null, yDate = null;
        Assert.isTrue(null != x || null != y, Constant.ERROR_MSG);

        if (format.equals(DateFormatEnum.YYYYMMDD)) {
            xStr = getDateStrFormatYMD(x);
            yStr = getDateStrFormatYMD(y);
            xDate = appendPlainHMS(xStr);
            yDate = appendPlainHMS(yStr);
        }
        if (format.equals(DateFormatEnum.HHMMSS)) {
            xStr = getDateStrFormatHMS(x);
            yStr = getDateStrFormatHMS(y);
            xDate = appendPlainYMD(xStr);
            yDate = appendPlainYMD(yStr);
        }
        return xDate.getTime() > yDate.getTime() ? 1 : (xDate.getTime() == yDate.getTime() ? 0 : -1);
    }

    /**
     * 获取年/月/日格式化时间字符串
     *
     * @param d
     * @return
     */
    static public String getDateStrFormatYMD(Date d) {
        return getDateStrByFormat(d, DateFormatEnum.YYYYMMDD);
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

    /**
     * 拼接年/月/日
     * @param s
     * @return
     */
    static public Date appendPlainYMD(String s) {
        return appendPlainByFormat(s, DateFormatEnum.YYYYMMDD);
    }
    /**
     * 拼接时/分/秒
     * @param s
     * @return
     */
    static public Date appendPlainHMS(String s) {
        return appendPlainByFormat(s, DateFormatEnum.HHMMSS);
    }

    /**
     * 根据format拼接时间
     * @param s
     * @param format
     * @return
     */
    static public Date appendPlainByFormat(String s, DateFormatEnum format) {
        Assert.isTrue(StringUtils.isNotBlank(s) && null != format, Constant.ERROR_MSG);
        Date d = null;
        String total = null;
        try {
            SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            total = DateFormatEnum.YYYYMMDD.equals(format)
                    ? Constant.STRING_YYYYMMDD.concat(Constant.SPACE).concat(s)
                    : s.concat(Constant.SPACE).concat(Constant.STRING_HHMMSS);
            d = SIMPLE_DATE_FORMAT.parse(total);
        } catch (Exception e) {
            logger.error("解析错误。格式{}，时间{}", format, total, e);
        }
        return d;
    }
}