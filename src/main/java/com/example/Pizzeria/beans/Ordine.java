package com.example.Pizzeria.beans;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ordine {
    private int id;
    List<Prodotto> prodotti=new ArrayList<>();
    @Autowired
    @Qualifier("tavolo")
    private Tavolo tavolo;
    StatoOrdine statoOrdine;
    LocalDateTime oraAcquisizione;
    private double importo;
    private int coperti;
    public void addProdotto(Prodotto p){
        prodotti.add(p);
        calcolaImporto();
    }
    private void calcolaImporto() {
        double totale=prodotti.stream().mapToDouble(Prodotto::getPrezzo).reduce(0,Double::sum);
        setImporto(  totale + (2* coperti)  );
    }
}
