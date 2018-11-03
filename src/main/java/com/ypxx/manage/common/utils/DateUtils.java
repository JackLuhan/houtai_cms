package com.ypxx.manage.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuwei on 2018/10/8.
 */
public class DateUtils {
    /**
     * 日期转字符串
     */
    public static String dateToStr(Date date){
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     */

    public static Date strToDate(String str){
        if (null == str || "".equals(str)) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
