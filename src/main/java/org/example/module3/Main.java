package org.example.module3;

import org.example.module3.adapter.BynAmount;
import org.example.module3.adapter.BynToUsdAdapter;
import org.example.module3.builder.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder()
                .name("Война и мир")
                .author("Лев Толстой")
                .numberOfPages(1225)
                .yearOfRelease(1869)
                .build();
        System.out.println(book);

        BynToUsdAdapter adapter = new BynToUsdAdapter(new BynAmount(1000));
        System.out.printf("1000 BYN = %.2f USD%n", adapter.getAmountInUSD());
    }
}