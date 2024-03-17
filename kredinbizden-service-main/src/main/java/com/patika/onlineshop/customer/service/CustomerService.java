package com.patika.onlineshop.customer.service;

import com.patika.onlineshop.customer.model.Customer;
import com.patika.onlineshop.customer.repo.MockCustomerRepo;
import com.patika.onlineshop.order.model.Order;
import com.patika.onlineshop.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class CustomerService {

    private final MockCustomerRepo mockCustomerRepo;


    public CustomerService() {
        this.mockCustomerRepo = new MockCustomerRepo();
    }

    public Integer getCustomersSize(){
        int size = mockCustomerRepo.getAll().size();
        System.out.println(size);
        return size;
    }

    public Integer listCustomerProductsSizeByName(String name){
        Customer customer = mockCustomerRepo.getAll().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
        Integer productsSize = customer == null
                ? 0
                : customer.getOrderList().stream()
                .map(Order::getProductList)
                .flatMap(List::stream)
                .toList().size();
        System.out.println(productsSize);
        return productsSize;
    }

    public BigDecimal getCustomerBillSizeByNameAndAge(String name, int startAge, int endAge){
        Customer customer = mockCustomerRepo.getAll().stream().filter(c -> c.getName().equals(name) && c.getAge() > startAge && c.getAge() < endAge).findFirst().orElse(null);
        BigDecimal billSize = customer == null
                ? BigDecimal.ZERO
                : customer.getOrderList().stream()
                .map(Order::getProductList)
                .flatMap(List::stream)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(billSize);
        return billSize;
    }
}
