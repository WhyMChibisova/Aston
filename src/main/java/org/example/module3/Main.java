package org.example.module3;

import org.example.module3.adapter.BynAmount;
import org.example.module3.adapter.BynToUsdAdapter;
import org.example.module3.builder.Book;
import org.example.module3.chain.NegativeNumberHandler;
import org.example.module3.chain.NumberHandler;
import org.example.module3.chain.PositiveNumberHandler;
import org.example.module3.chain.ZeroNumberHandler;
import org.example.module3.decorator.ClassicMassage;
import org.example.module3.decorator.FaceMaskDecorator;
import org.example.module3.decorator.SpaProcedure;
import org.example.module3.decorator.TeaCeremonyDecorator;
import org.example.module3.proxy.SpaService;
import org.example.module3.proxy.SpaServiceProxy;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    private static final int RANGE_LIMIT = 10;

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
        System.out.printf("Price: %.2f, Duration: %d min%n",
                massageWithFaceMaskAndTeaCeremony.getPrice(),
                massageWithFaceMaskAndTeaCeremony.getDuration());

        SpaService spaService = new SpaServiceProxy();
        spaService.book(massageWithFaceMaskAndTeaCeremony);

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