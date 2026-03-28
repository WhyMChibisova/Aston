package org.example.module3;

import org.example.module3.adapter.BynAmount;
import org.example.module3.adapter.BynToUsdAdapter;
import org.example.module3.builder.Book;
import org.example.module3.decorator.ClassicMassage;
import org.example.module3.decorator.FaceMaskDecorator;
import org.example.module3.decorator.SpaProcedure;
import org.example.module3.decorator.TeaCeremonyDecorator;

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

        SpaProcedure massageWithFaceMaskAndTeaCeremony = new TeaCeremonyDecorator(
                                                            new FaceMaskDecorator(
                                                                    new ClassicMassage()));
        System.out.printf("Price: %.2f, Duration: %d min",
                massageWithFaceMaskAndTeaCeremony.getPrice(),
                massageWithFaceMaskAndTeaCeremony.getDuration());
    }
}