package com.seele0oO.oldJDBC.utils;



import java.text.SimpleDateFormat;
import java.util.Date;

public class toolUtil {
    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        if(str != null &&! "".equals(str.trim())) {
            return false;
        }
        return true;
    }
    //获取系统当前时间的毫秒数
    public static Long getTime() {
        //return new Date().getTime();
        return System.currentTimeMillis();

    }
    //将Long时间毫秒值转换成指定格式的日期时间字符串
    public static String getTimeByString(Long time) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy--MM-dd HH:mm:ss");
        String s = sdf.format(new Date(time));
        return s;

    }

}


