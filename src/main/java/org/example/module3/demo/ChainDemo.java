package org.example.module3.demo;

import org.example.module3.chain.NegativeNumberHandler;
import org.example.module3.chain.NumberHandler;
import org.example.module3.chain.PositiveNumberHandler;
import org.example.module3.chain.ZeroNumberHandler;

import java.util.Random;
import java.util.stream.IntStream;

public class ChainDemo implements PatternDemo {
    private static final int RANGE_LIMIT = 10;

    @Override
    public void demonstrate() {
        NumberHandler negativeNumberHandler = new NegativeNumberHandler();
        NumberHandler zeroNumberHandler = new ZeroNumberHandler();
        NumberHandler positiveNumberHandler = new PositiveNumberHandler();
        negativeNumberHandler.setNext(zeroNumberHandler);
        zeroNumberHandler.setNext(positiveNumberHandler);

        IntStream.generate(() -> new Random().nextInt(2 * RANGE_LIMIT + 1) - RANGE_LIMIT)
                .limit(RANGE_LIMIT)
                .forEach(negativeNumberHandler::validate);
    }
}