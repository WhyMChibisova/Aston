package org.example.module3.proxy;

import org.example.module3.decorator.SpaProcedure;

import java.util.logging.Logger;

public class SpaServiceProxy implements SpaService {
    private final SpaServiceImpl spaService = new SpaServiceImpl();
    private final Logger logger = Logger.getLogger(SpaServiceProxy.class.getName());

    @Override
    public void book(SpaProcedure procedure) {
        logger.info("Procedure booked");
        spaService.book(procedure);
    }
}