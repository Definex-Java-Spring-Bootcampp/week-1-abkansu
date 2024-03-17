package com.patika.onlineshop.bill.model;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;

    public Bill(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return String.valueOf(this.amount);
    }
}
