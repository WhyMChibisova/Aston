package org.example.module3.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BynToUsdAdapter implements UsdCurrency {
    private final BynAmount bynAmount;
    private final BigDecimal EXCHANGE_RATE = BigDecimal.valueOf(2.95);

    public BynToUsdAdapter(final BynAmount bynAmount) {
        this.bynAmount = bynAmount;
    }

    @Override
    public BigDecimal getAmountInUSD() {
        return bynAmount.getAmount().divide(EXCHANGE_RATE, 2, RoundingMode.HALF_UP);
    }
}