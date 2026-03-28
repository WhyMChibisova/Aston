package org.example.module3;

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
    }
}