package org.example.module3.decorator;

public class FaceMaskDecorator extends SpaProcedureDecorator {
    private final double FACE_MASK_PRICE = 10;
    private final int FACE_MASK_DURATION_IN_MINUTES = 15;

    public FaceMaskDecorator(SpaProcedure spaProcedure) {
        super(spaProcedure);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + FACE_MASK_PRICE;
    }

    @Override
    public int getDuration() {
        return super.getDuration() + FACE_MASK_DURATION_IN_MINUTES;
    }
}