package org.example.module3.decorator;

public abstract class SpaProcedureDecorator implements SpaProcedure {
    private final SpaProcedure spaProcedure;

    public SpaProcedureDecorator(SpaProcedure spaProcedure) {
        this.spaProcedure = spaProcedure;
    }

    @Override
    public double getPrice() {
        return spaProcedure.getPrice();
    }

    @Override
    public int getDuration() {
        return spaProcedure.getDuration();
    }
}