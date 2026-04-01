package org.example.module3.adapter;

import java.math.BigDecimal;

public class BynAmount {
    private final BigDecimal amount;

    public BynAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}