package com.patika.onlineshop.bill.repo;

import com.patika.onlineshop.bill.model.Bill;
import com.patika.onlineshop.customer.model.Customer;
import com.patika.onlineshop.customer.repo.MockCustomerRepo;
import com.patika.onlineshop.order.model.Order;

import java.util.List;

public class MockBillRepo {

    private final MockCustomerRepo mockCustomerRepo;

    public MockBillRepo(MockCustomerRepo mockCustomerRepo) {
        this.mockCustomerRepo = mockCustomerRepo;
    }

    public List<Bill> getAll(){
        return mockCustomerRepo.getAll().stream().map(Customer::getOrderList).flatMap(List::stream).map(Order::getBill).toList();
    }
}
