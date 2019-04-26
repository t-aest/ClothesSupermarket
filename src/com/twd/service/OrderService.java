package com.twd.service;

import com.twd.bean.Order;
import com.twd.utils.BusinessException;

import java.util.List;

/**
 * @Classname OrderService
 * @Date 2019/4/24 21:03
 * @Created by Administrator
 */
public interface OrderService {

    public void buyProduct(Order o)throws BusinessException;
    public List<Order> list()throws BusinessException;
    public Order findById(int orderId)throws BusinessException;
}
