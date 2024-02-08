package com.example.Pizzeria;

import com.example.Pizzeria.beans.Menu;
import com.example.Pizzeria.beans.Ordine;
import com.example.Pizzeria.beans.Prodotto;
import com.example.Pizzeria.services.OrdineService;
import com.example.Pizzeria.services.ProdottoService;
import com.example.Pizzeria.services.TavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private TavoloService tavoloService;
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Menu m=ctx.getBean(Menu.class);
//        m.getListaAggiunte().forEach(el->prodottoService.save(el));
//        m.getListaPizze().forEach(el->prodottoService.save(el));
//        m.getListaBevande().forEach(el->prodottoService.save(el));

        Ordine o=ctx.getBean(Ordine.class);
//        tavoloService.save(o.getTavolo());
//        ordineService.save(o);

        prodottoService.findOverCalories(50).forEach(System.out::println);
        prodottoService.findPizzaUnderPrezzo(6).forEach(System.out::println);
        System.out.println(prodottoService.findByName("Mozzarella"));
    }
}
