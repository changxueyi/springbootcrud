package com.cxy.common.utils;

import sun.plugin2.message.Message;

import java.text.MessageFormat;

/**
 * @ClassName messageFormat
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 17:21
 */
public class messageFormat {
    public static String messageFormat(String pattern, String... arr) {
        if (pattern == null || arr == null) {
            return "";
        }
        return new MessageFormat(pattern).format(arr);
    }

    public static String messageFormat2(String pattern, Object[] arr) {
        if (pattern == null || arr == null) {
            return "";
        }
        return new MessageFormat(pattern).format(arr);
    }

    public static void main(String[] args) {
        /*String pattern = "changxueyi:{0}:{1}";
       // Object[] arr = new Object[]{"aa","bb"};
        String aaa = "liyanru";
        String bbb = "liyanru2";
        System.out.println(messageFormat(pattern,aaa,bbb));*/
        //String  pattern = "changxueyi:{0}:{1}";
        String[] arr = new String[]{"aa", "bb"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //System.out.println(messageFormat2(pattern,arr));
    }
}