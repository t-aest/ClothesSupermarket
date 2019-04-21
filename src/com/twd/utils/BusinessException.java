package com.twd.utils;

/**
 * @Classname BusinessException
 * @Date 2019/4/20 22:01
 * @Created by Administrator
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){
        super();
    }
    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
