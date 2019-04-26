package com.twd.service.impl;

import com.twd.bean.Order;
import com.twd.service.OrderService;
import com.twd.utils.BusinessException;

import java.util.List;

/**
 * @Classname OrderServiceImpl
 * @Date 2019/4/24 21:07
 * @Created by Administrator
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void buyProduct(Order o) throws BusinessException {

    }

    @Override
    public List<Order> list() throws BusinessException {
        return null;
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return null;
    }
}
