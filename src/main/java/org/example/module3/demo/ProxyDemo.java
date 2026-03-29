package org.example.module3.demo;

import org.example.module3.decorator.ClassicMassage;
import org.example.module3.decorator.SpaProcedure;
import org.example.module3.proxy.SpaService;
import org.example.module3.proxy.SpaServiceProxy;

public class ProxyDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        SpaProcedure classicMassage = new ClassicMassage();

        SpaService spaService = new SpaServiceProxy();
        spaService.book(classicMassage);
    }
}