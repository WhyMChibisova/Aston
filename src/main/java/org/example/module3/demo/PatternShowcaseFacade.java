package org.example.module3.demo;

import java.util.List;

public class PatternShowcaseFacade {
    private final List<PatternDemo> demos;

    public PatternShowcaseFacade() {
        this.demos = List.of(
                new StrategyDemo(),
                new ChainDemo(),
                new BuilderDemo(),
                new ProxyDemo(),
                new DecoratorDemo(),
                new AdapterDemo()
        );
    }

    public void demonstrateAll() {
        demos.forEach(demo -> {
            System.out.println("--- " + demo.getClass().getSimpleName() + " ---");
            demo.demonstrate();
        });
    }
}