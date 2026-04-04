package org.example.module3.chain;

public class ZeroNumberHandler extends NumberHandler {
    @Override
    public void validate(int number) {
        if (number == 0) {
            System.out.println("Number is zero");
        } else if (next != null) {
            next.validate(number);
        }
    }
}