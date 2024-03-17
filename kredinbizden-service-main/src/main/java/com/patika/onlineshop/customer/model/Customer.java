package com.patika.onlineshop.customer.model;

import com.patika.onlineshop.bill.model.Bill;
import com.patika.onlineshop.order.model.Order;

import java.math.BigDecimal;
import java.util.List;

public class Customer {

    private String name;
    private List<Order> orderList;
    private int age;

    public Customer(String name, List<Order> orderList, int age) {
        this.name = name;
        this.orderList = orderList;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        BigDecimal billAmount = this.orderList.stream().map(Order::getBill).map(Bill::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        return "Name: " + this.name + " Age: " + this.age + " Bill amount: " + billAmount;
    }
}
