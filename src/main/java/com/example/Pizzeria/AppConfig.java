package com.example.Pizzeria;

import com.example.Pizzeria.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean("pomodoro")
    public Aggiunta getPomodoro(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0);
        a.setCalorie(50);
        a.setNome("Pomodoro");
        return a;
    }
    @Bean("mozzarella")
    public Aggiunta getMozzarella(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0.69);
        a.setCalorie(92);
        a.setNome("Mozzarella");
        return a;
    }
    @Bean("prosciutto")
    public Aggiunta getProsciutto(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0.99);
        a.setCalorie(35);
        a.setNome("Prosciutto");
        return a;
    }
    @Bean("cipolla")
    public Aggiunta getCipolla(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0.69);
        a.setCalorie(22);
        a.setNome("Cipolla");
        return a;
    }
    @Bean("ananas")
    public Aggiunta getAnanas(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0.79);
        a.setCalorie(24);
        a.setNome("Ananas");
        return a;
    }
    @Bean("salame")
    public Aggiunta getSalame(){
        Aggiunta a=new Aggiunta();
        a.setPrezzo(0.99);
        a.setCalorie(86);
        a.setNome("Salame");
        return a;
    }

    @Bean("limonata")
    public Bevanda getLimonata(){
        Bevanda b=new Bevanda();
        b.setPrezzo(1.29);
        b.setNome("Limonata");
        b.setCalorie(128);
        return b;
    }
    @Bean("acqua")
    public Bevanda getAcqua(){
        Bevanda b=new Bevanda();
        b.setPrezzo(1.29);
        b.setNome("Acqua");
        b.setCalorie(0);
        return b;
    }
    @Bean("vino")
    public Bevanda getVino(){
        Bevanda b=new Bevanda();
        b.setPrezzo(7.49);
        b.setNome("Vino");
        b.setCalorie(607);
        return b;
    }

    @Bean("margherita")
    @Scope("prototype")
    public Pizza getMargherita(){
        Pizza p=new Pizza();
        p.setNome("Margherita");
        p.addAggiunta(getMozzarella());
        p.addAggiunta(getPomodoro());
        return p;
    }
    @Bean("hawaiana")
    public Pizza getHawaiana(){
        Pizza p=getMargherita();
        p.setNome("Hawaiana");
        p.addAggiunta(getProsciutto());
        p.addAggiunta(getAnanas());
        return p;
    }
    @Bean("salamiPizza")
    public Pizza getPizzaSalami(){
        Pizza p=getMargherita();
        p.setNome("Salami");
        p.addAggiunta(getSalame());
        return p;
    }

    @Bean
    public Menu getMenu(){
        Menu m=new Menu();
        m.addPizza(getMargherita());
        m.addPizza(getPizzaSalami());
        m.addPizza(getHawaiana());

        m.addBevanda(getAcqua());
        m.addBevanda(getVino());
        m.addBevanda(getLimonata());

        m.addAggiunta(getAnanas());
        m.addAggiunta(getCipolla());
        m.addAggiunta(getProsciutto());
        m.addAggiunta(getSalame());
        m.addAggiunta(getMozzarella());
        return m;
    }

    @Bean("tavolo")
    public Tavolo tavolo(@Value("${Pizzeria.maxCoperti}") String postiMax){
        Tavolo t=new Tavolo();
        t.setStatoTavolo(StatoTavolo.OCCUPATO);
        t.setMaxCoperti(Integer.parseInt(postiMax));
        return t;
    }

    @Bean("tavolo1")
    public Tavolo getTavolo(){
        Tavolo t=new Tavolo();
        t.setStatoTavolo(StatoTavolo.OCCUPATO);
        t.setMaxCoperti(5);
        return t;
    }
    @Bean("ordine1")
    public Ordine ordine(){
        Ordine o=new Ordine();
        o.setCoperti(2);
        o.setTavolo(getTavolo());
        o.addProdotto(getMargherita());
        o.addProdotto(getPizzaSalami());
        o.addProdotto(getAcqua());
        o.addProdotto(getProsciutto());
        o.setStatoOrdine(StatoOrdine.IN_CORSO);
        o.setOraAcquisizione(LocalDateTime.now());
        return o;
    }
}
