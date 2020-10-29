package com.cxy.common.utils;


import com.cxy.common.enums.ResponseStatus;
import com.cxy.common.exception.BaseAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UtilHelper.java
 * @Description  工具类，定义一些静态方法
 * @Author liufenglei
 * @Date 2018/9/14 10:27
 * @Version 1.0
 **/
public class UtilHelper {


    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(UtilHelper.class);

    UtilHelper(){

    }

    /**
     * 数据库查出的数据集合，转换为页面输出的数据集合
     * @param list 数据源
     * @param clazz 需要转出的数据集合
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> conversionList(List<?> list, Class<T> clazz) throws Exception {
        // 非空判断
        if (list == null || list.size() == 0) {
            return new ArrayList<T>();
        }

        // 方法返回值
        List<T> retList = new ArrayList<T>();

        for (int i = 0; i < list.size(); i++) {

            // 重新实例化一个类
            T newObj = clazz.newInstance();
            Object oldObj = list.get(i);

            try {
                // 把一个类的属性值复制到另一个类
                BeanUtils.copyProperties(newObj, oldObj);
            } catch (Exception e) {
                logger.error("复制对象属性出错，错误信息为{}", e.getMessage());
                e.printStackTrace();
                throw e;
            }
            retList.add(newObj);
        }
        return retList;
    }

    /**
     *
     * 根据org.springframework.beans.BeanUtils，数据库查出的数据集合，转换为页面输出的数据集合
     *
     * @param list 数据源
     * @param clazz 需要转出的数据集合
     * @return
     * @throws Exception
     */
    public static <T> List<T> conversionListBySpringBeanUtils(List<?> list, Class<T> clazz) throws Exception {
        // 非空判断，参数为空，返回空的List
        if (list == null || list.isEmpty()) {
            return new ArrayList<T>();
        }

        // 方法返回值
        List<T> retList = new ArrayList<T>();

        for (int i = 0; i < list.size(); i++) {

            // 重新实例化一个类
            T newObj = clazz.newInstance();
            Object oldObj = list.get(i);

            // 把一个类的属性值复制到另一个类
            BeanUtils.copyProperties(oldObj, newObj);
            retList.add(newObj);
        }
        return retList;
    }

    /**
     * 验证对象不为空
     * @param object
     * @param responseStatus
     */
    public static void assertNotNUll(Object object, ResponseStatus responseStatus) {
        assertTrue(object != null, responseStatus);
    }

    /**
     * 验证不能为空
     * @param str 待验证字符串
     * @param responseStatus 验证不通过的错误提示信息
     * @return void
     * @throws
     */
    public static void assertNotBlank(String str, ResponseStatus responseStatus) {
        assertTrue(str != null && !"".trim().equals(str), responseStatus);
    }

    /**
     * 判断 大于零
     * @param i
     * @param responseStatus
     */
    public static void assertGreaterThanZero(Integer i, ResponseStatus responseStatus) {
        assertTrue(i != null && i > 0, responseStatus);
    }
    public static void assertGreaterThanZero(Long i, ResponseStatus responseStatus) {
        assertTrue(i != null && i > 0, responseStatus);
    }

    public static void assertTrue(boolean expression, ResponseStatus responseStatus) throws BaseAppException {
        try {
            Assert.isTrue(expression);
        } catch (IllegalArgumentException var4) {
            logger.error("参数验证不通过，错误信息为：code={}, msg={}", responseStatus.code, responseStatus.msg);
            throw new BaseAppException(responseStatus);
        }
    }

    /**
     * object --> String
     * @param object
     * @return
     */
    public static String toString(Object object) {
        try {
            if(null != object) {
                return object.toString();
            }
        } catch (Exception e) {
            logger.error("转换JSON字符串出错，错误信息为：", e);
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
