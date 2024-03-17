package com.patika.onlineshop.bill.service;

import com.patika.onlineshop.bill.model.Bill;
import com.patika.onlineshop.bill.repo.MockBillRepo;
import com.patika.onlineshop.customer.repo.MockCustomerRepo;

import java.math.BigDecimal;
import java.util.List;

public class BillService {
    private final MockBillRepo mockBillRepo;

    public BillService(MockCustomerRepo mockCustomerRepo) {
        this.mockBillRepo = new MockBillRepo(mockCustomerRepo);
    }

    public List<Bill> listBillsGreaterThan(BigDecimal amount){
        List<Bill> list = mockBillRepo.getAll().stream().filter(bill -> bill.getAmount().compareTo(amount) > 0).toList();
        list.forEach(bill -> System.out.println(bill.toString()));

        return list;
    }
}
