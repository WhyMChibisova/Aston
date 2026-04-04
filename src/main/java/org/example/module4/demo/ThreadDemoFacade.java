package org.example.module4.demo;

import java.util.List;

public class ThreadDemoFacade {
    private final List<ThreadDemo> demos;

    public ThreadDemoFacade() {
        this.demos = List.of(
                new DeadlockDemo(),
                new LivelockDemo()
        );
    }

    public void demonstrateAll() {
        demos.forEach(ThreadDemo::demonstrate);
    }
}