package com.twd.service.impl;

import com.twd.bean.Order;
import com.twd.service.OrderService;
import com.twd.utils.BusinessException;
import com.twd.utils.OrderIo;

import java.util.List;

/**
 * @Classname OrderServiceImpl
 * @Date 2019/4/24 21:07
 * @Created by Administrator
 */
public class OrderServiceImpl implements OrderService {
    private OrderIo orderIo = new OrderIo();
    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIo.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIo.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIo.findByOrderId(orderId);
    }
}
