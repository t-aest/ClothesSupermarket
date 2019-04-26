package com.twd.ui;

import com.twd.bean.User;
import com.twd.service.UserService;
import com.twd.utils.BusinessException;

/**
 * @Classname RegisterClass
 * @Date 2019/4/20 21:59
 * @Created by Administrator
 */
public class RegisterClass extends BaseClass {
    private UserService userService;
    public RegisterClass(){
        userService = ((UserService) beanFactory.getBean("userService"));
    }
    public void register() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        userService.register(user);
    }
}
