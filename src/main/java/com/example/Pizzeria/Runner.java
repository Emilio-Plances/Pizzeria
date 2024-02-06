package com.example.Pizzeria;

import com.example.Pizzeria.beans.Ordine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Ordine o=ctx.getBean("ordine1", Ordine.class);
        System.out.println(o);
    }
}
