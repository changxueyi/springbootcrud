package com.cxy.common.cache;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.text.MessageFormat;

/**
 * @ClassName CacheUtil
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 18:23
 */
public class CacheUtil {

    public static class CacheKey {
        /**
         * 设置缓存前缀
         */
        public final static String KEY_PREFIX = "bt:sc:";

        /**
         * 积分生效的key
         */
        public final static String VALID_SCORE = "valid:score:{0}:{1}";
    }

    public final static Long CACHE_TIME_MONTH = 2592000L;
    public final static Long CACHE_TIME_WEEK = 604800L;
    public final static Long CACHE_TIME_DAY = 86400L;
    public final static Long CACHE_TIME_HOUR = 3600L;
    public final static Long CACHE_TIME_MINUTE = 60L;
    public final static Long CACHE_TIME_SECONDS = 3L;

    public enum CacheTimeIndex {
        MONTH(1),
        WEEK(2),
        DAY(3),
        HOUR(4),
        MINUTE(5),
        SECONDS(6);

        public int t;

        CacheTimeIndex(int t) {
            this.t = t;
        }
    }

    public static Integer getCacheTime(CacheTimeIndex i) {
        switch (i.t) {
            case 1:
                return CACHE_TIME_MONTH.intValue();
            case 2:
                return CACHE_TIME_WEEK.intValue();
            case 3:
                return CACHE_TIME_DAY.intValue();
            case 4:
                return CACHE_TIME_HOUR.intValue();
            case 5:
                return CACHE_TIME_MINUTE.intValue();
            case 6:
                return CACHE_TIME_SECONDS.intValue();
            default:
                return CACHE_TIME_MINUTE.intValue();
        }
    }

    public static String messageFormat(String pattern, String... arr) {
        if (pattern == null || arr == null) {
            return "";
        }
        return new MessageFormat(pattern).format(arr);
    }
}