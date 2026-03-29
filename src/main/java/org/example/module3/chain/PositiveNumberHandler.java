package org.example.module3.chain;

public class PositiveNumberHandler extends NumberHandler {
    @Override
    public void validate(int number) {
        if (number > 0) {
            System.out.printf("Number %d is positive%n", number);
        } else if (next != null) {
            next.validate(number);
        }
    }
}