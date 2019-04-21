package com.twd.bean;

import java.io.Serializable;

/**
 * @Classname OrderItem
 * @Date 2019/4/18 21:20
 * @Created by Administrator
 */
public class OrderItem implements Serializable {

    private int itemId;
    private Clothes colthes;//商品
    private int shoppingNum;
    private float sum;//购买金额

    public OrderItem() {
    }

    public OrderItem(int itemId, Clothes colthes, int shoppingNum, float sum) {
        this.itemId = itemId;
        this.colthes = colthes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getColthes() {
        return colthes;
    }

    public void setColthes(Clothes colthes) {
        this.colthes = colthes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
