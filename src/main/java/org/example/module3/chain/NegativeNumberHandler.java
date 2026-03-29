package org.example.module3.chain;

public class NegativeNumberHandler extends NumberHandler {
    @Override
    public void validate(int number) {
        if (number < 0) {
            System.out.printf("Number %d is negative%n", number);
        } else if (next != null) {
            next.validate(number);
        }
    }
}