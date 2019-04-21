package com.twd.ui;

import com.twd.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Classname BaseClass
 * @Date 2019/4/20 12:25
 * @Created by Administrator
 */
public abstract class BaseClass {
    protected  static Scanner input = new Scanner(System.in);
    protected static User currUser;//当前用户对象
    private static ResourceBundle r = ResourceBundle.getBundle("com.twd.res.r");
    public static String getString(String key){
        return r.getString(key);
    }

    public static void println(String s){
        System.out.println(s);
    }
    public static void print(String s){
        System.out.print(s);
    }



}
