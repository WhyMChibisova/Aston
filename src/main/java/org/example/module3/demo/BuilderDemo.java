package org.example.module3.demo;

import org.example.module3.builder.Book;

public class BuilderDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        Book book = Book.builder()
                .name("Война и мир")
                .author("Лев Толстой")
                .numberOfPages(1225)
                .yearOfRelease(1869)
                .build();
        System.out.println(book);
    }
}