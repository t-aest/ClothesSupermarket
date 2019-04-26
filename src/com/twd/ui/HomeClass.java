package com.twd.ui;

import com.twd.bean.Clothes;
import com.twd.bean.Order;
import com.twd.bean.OrderItem;
import com.twd.service.ClothesService;
import com.twd.service.OrderService;
import com.twd.service.impl.ClothesServiceImpl;
import com.twd.utils.BusinessException;
import com.twd.utils.ConsoleTable;
import com.twd.utils.DateUtils;
import java.util.Date;
import java.util.List;
/**
 * @Classname HomeClass
 * @Date 2019/4/22 20:19
 * @Created by Administrator
 */
public class HomeClass extends BaseClass {

    private OrderService orderService;
    private ClothesService clothesService;
    public HomeClass(){
        orderService = (OrderService) beanFactory.getBean("orderService");
        clothesService = (ClothesService) beanFactory.getBean("clothesService");
    }
    public void show() {
        showProducts();
        println("welcome:" + currUser.getUsername());
        menu();
    }
    private void menu(){
        boolean flag = true;
        while (flag) {
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select) {
                case "1"://1、查询全部订单
                    findOrderList();
                    flag = false;
                    break;
                case "2"://2、查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3"://3、购买
                    try {
                        buyProducts();
                        flag = false;
                    } catch (BusinessException e) {
                        println(e.getMessage());
                    }
                    break;
                case "4"://显示商品
                    show();
                    break;
                case "0"://0、退出系统
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;

            }

        }
    }
    /**
     * @Author Alex
     * @Description 购买商品
     * @Date 22:07 2019/4/24
     * @Param []
     * @return void
     **/
    private void buyProducts() throws BusinessException {
        //生成订单
        boolean flag = true;
        int count = 1;
        float sum = 0.0f;//订单总金额
        Order order = new Order();//生成的订单
        while (flag) {

            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);
            int num = Integer.parseInt(shoppingNum);
            if (num > clothes.getNum()) {
                throw new BusinessException("product.num.error");
            }
            //一条订单明细
            clothes.setNum(clothes.getNum()-num);//减去库存
            orderItem.setColthes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice() * num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);
            println(getString("product.buy.continue"));
            String isbuy = input.nextLine();
            switch (isbuy) {
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size() + 1);
        orderService.buyProduct(order);
        clothesService.update();
        show();
    }

    private void findOrderById() {
        println(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findById(Integer.parseInt(oid));
        if(order!=null){
            showOrder(order);
        }else{
            println(getString("product.order.error"));
        }
        menu();
    }
    //查询订单列表
    private void findOrderList() {

        List<Order> list = orderService.list();
        for(Order o:list){
            showOrder(o);
        }
        menu();
    }

    private void showOrder(Order o) {
        print(getString("product.order.oid")+o.getOrderId());
        print("\t"+getString("product.order.createDate")+o.getCreateDate());
        print("\t"+getString("product.order.sum")+o.getSum());
        ConsoleTable t = new ConsoleTable(9, true);
        t.appendRow();
        t.appendColum("itemId")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("price")
                .appendColum("description")
                .appendColum("shoppingNum")
                .appendColum("sum");
        for (OrderItem item : o.getOrderItemList()) {
            t.appendRow();
            t.appendColum(item.getItemId())
                    .appendColum(item.getColthes().getBrand())
                    .appendColum(item.getColthes().getStyle())
                    .appendColum(item.getColthes().getColor())
                    .appendColum(item.getColthes().getSize())
                    .appendColum(item.getColthes().getPrice())
                    .appendColum(item.getColthes().getDescription())
                    .appendColum(item.getShoppingNum())
                    .appendColum(item.getSum());
        }
        println(t.toString());
    }

    private void showProducts() {
        System.out.println("sss");
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");
        for (Clothes c : list) {
            t.appendRow();
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }
        println(t.toString());
    }
}
