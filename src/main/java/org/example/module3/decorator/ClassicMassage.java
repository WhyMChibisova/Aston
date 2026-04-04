package org.example.module3.decorator;

public class ClassicMassage implements SpaProcedure {
    private final double MASSAGE_PRICE = 50;
    private final int MASSAGE_DURATION_IN_MINUTES = 60;

    @Override
    public double getPrice() {
        return MASSAGE_PRICE;
    }

    @Override
    public int getDuration() {
        return MASSAGE_DURATION_IN_MINUTES;
    }
}