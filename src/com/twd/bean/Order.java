package com.twd.bean;

import com.twd.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Order
 * @Date 2019/4/18 21:19
 * @Created by Administrator
 */
public class Order implements Serializable {

    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String createDate;
    private float sum;//总金额
    private OrderStatusType status = OrderStatusType.UNPAID;//状态
    private int userId;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
