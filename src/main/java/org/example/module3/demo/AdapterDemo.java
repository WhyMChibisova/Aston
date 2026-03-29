package org.example.module3.demo;

import org.example.module3.adapter.BynAmount;
import org.example.module3.adapter.BynToUsdAdapter;

public class AdapterDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        BynToUsdAdapter adapter = new BynToUsdAdapter(new BynAmount(1000));
        System.out.printf("1000 BYN = %.2f USD%n", adapter.getAmountInUSD());
    }
}