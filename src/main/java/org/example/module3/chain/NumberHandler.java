package org.example.module3.chain;

public abstract class NumberHandler {
    protected NumberHandler next;

    public void setNext(NumberHandler next) {
        this.next = next;
    }

    public abstract void validate(int number);
}