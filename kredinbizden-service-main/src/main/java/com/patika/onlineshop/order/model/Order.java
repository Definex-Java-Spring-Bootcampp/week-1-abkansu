package com.patika.onlineshop.order.model;

import com.patika.onlineshop.bill.model.Bill;
import com.patika.onlineshop.product.model.Product;

import java.util.List;

public class Order {

    private List<Product> productList;
    private Bill bill;

    public Order(List<Product> productList, Bill bill) {
        this.productList = productList;
        this.bill = bill;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
