package com.patika.onlineshop.product.model;

import com.patika.onlineshop.product.enums.Category;

import java.math.BigDecimal;

public class Product {
    private Category category;
    private BigDecimal price;
    private String name;
    private int stock;

    public Product(Category category, BigDecimal price, String name, int stock) {
        this.category = category;
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
