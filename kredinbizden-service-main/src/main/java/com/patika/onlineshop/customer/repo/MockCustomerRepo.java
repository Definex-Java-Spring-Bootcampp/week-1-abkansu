package com.patika.onlineshop.customer.repo;

import com.patika.onlineshop.product.enums.Category;
import com.patika.onlineshop.product.model.Product;
import com.patika.onlineshop.bill.model.Bill;
import com.patika.onlineshop.customer.model.Customer;
import com.patika.onlineshop.order.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockCustomerRepo {

    private final List<Customer>  customerList;

    public MockCustomerRepo() {
        this.customerList = populateCustomerList();
    }

    public List<Customer> getAll(){
        return this.customerList;
    }


    private List<Customer> populateCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            List<Order> orderList = new ArrayList<>();
            int random = 3 + (int)(Math.random() * ((15 - 3) + 1));
            for(int j = 0; j < random; j++){
                List<Product> productList = new ArrayList<>();

                for(int k = 0; k < random; k++){
                    productList.add(
                            new Product(
                                    Category.OTHER,
                                    BigDecimal.TEN.add(BigDecimal.valueOf(k)),
                                    "Prodcut" + k,
                                    k
                            )
                    );
                }
                orderList.add(
                        new Order(
                                productList,
                                new Bill(productList.stream()
                                        .map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                        )
                );
            }
            customerList.add(new Customer(
                    "Bera" + i,
                    orderList,
                    random + 10
            ));
        }
        return customerList;
    }


}
