package com.twd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Date 2019/4/24 21:47
 * @Created by Administrator
 */
public class DateUtils {

    public static String toDate(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
