package org.example.module3.demo;

import org.example.module3.decorator.ClassicMassage;
import org.example.module3.decorator.FaceMaskDecorator;
import org.example.module3.decorator.SpaProcedure;
import org.example.module3.decorator.TeaCeremonyDecorator;

public class DecoratorDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        SpaProcedure massageWithFaceMaskAndTeaCeremony = new TeaCeremonyDecorator(
                new FaceMaskDecorator(
                        new ClassicMassage()));
        System.out.printf("Price: %.2f, Duration: %d min%n",
                massageWithFaceMaskAndTeaCeremony.getPrice(),
                massageWithFaceMaskAndTeaCeremony.getDuration());
    }
}