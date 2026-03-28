package org.example.module3.adapter;

public class BynToUsdAdapter implements UsdCurrency {
    private final BynAmount bynAmount;
    private final double EXCHANGE_RATE = 2.95;

    public BynToUsdAdapter(final BynAmount bynAmount) {
        this.bynAmount = bynAmount;
    }

    @Override
    public double getAmountInUSD() {
        return bynAmount.getAmount() / EXCHANGE_RATE;
    }
}