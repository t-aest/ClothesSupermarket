package com.twd.service.impl;

import com.twd.bean.User;
import com.twd.service.UserService;
import com.twd.utils.BusinessException;
import com.twd.utils.EmptyUtils;
import com.twd.utils.UserIo;
import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * @Classname UserServiceImpl
 * @Date 2019/4/20 22:12
 * @Created by Administrator
 */
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) throws BusinessException {
        UserIo userIo = new UserIo();
        userIo.add(user);
        userIo.writeUsers();
        return user;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if (EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if (EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }
        UserIo userIo = new UserIo();
        User user = userIo.findByUserAndPass(username, password);
        return user;
    }
}
