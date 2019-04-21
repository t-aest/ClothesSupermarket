package com.twd.utils;

/**
 * @Classname EmptyUtils
 * @Date 2019/4/21 14:15
 * @Created by Administrator
 */
public class EmptyUtils {

    public static boolean isEmpty(String s){

        if (null==s||"".equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
