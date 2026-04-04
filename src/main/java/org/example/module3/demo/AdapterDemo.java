package org.example.module3.demo;

import org.example.module3.adapter.BynAmount;
import org.example.module3.adapter.BynToUsdAdapter;

import java.math.BigDecimal;

public class AdapterDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        BynToUsdAdapter adapter = new BynToUsdAdapter(new BynAmount(BigDecimal.valueOf(1000)));
        System.out.printf("1000 BYN = %.2f USD%n", adapter.getAmountInUSD());
    }
}