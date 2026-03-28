package org.example.module3.decorator;

public class TeaCeremonyDecorator extends SpaProcedureDecorator {
    private final double TEA_CEREMONY_PRICE = 40;
    private final int TEA_CEREMONY_DURATION_IN_MINUTES = 30;

    public TeaCeremonyDecorator(SpaProcedure spaProcedure) {
        super(spaProcedure);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + TEA_CEREMONY_PRICE;
    }

    @Override
    public int getDuration() {
        return super.getDuration() + TEA_CEREMONY_DURATION_IN_MINUTES;
    }
}