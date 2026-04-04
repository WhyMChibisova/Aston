package org.example.module3.proxy;

import org.example.module3.decorator.SpaProcedure;

public class SpaServiceImpl implements SpaService {
    @Override
    public void book(SpaProcedure procedure) {
        System.out.println("Price: " + procedure.getPrice());
    }
}