package com.twd.service;

import com.twd.bean.User;
import com.twd.utils.BusinessException;

/**
 * @Classname UserService
 * @Date 2019/4/20 22:10
 * @Created by Administrator
 */
public interface UserService {

    public User register(User user) throws BusinessException;
    public User login(String username,String password) throws BusinessException;
}
