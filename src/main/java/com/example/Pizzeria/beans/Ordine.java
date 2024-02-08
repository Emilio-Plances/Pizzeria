package com.example.Pizzeria.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "listaOrdini")
    List<Prodotto> ListaProdotti=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="tavolo_fk")
    private Tavolo tavolo;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_ordine")
    StatoOrdine statoOrdine;

    @Column(name="ora_acquisizione")
    LocalDateTime oraAcquisizione;
    private double importo;
    private int coperti;
    public void addProdotto(Prodotto p){
        ListaProdotti.add(p);
        calcolaImporto();
    }
    private void calcolaImporto() {
        double totale=ListaProdotti.stream().mapToDouble(Prodotto::getPrezzo).reduce(0,Double::sum);
        setImporto(  totale + (2* coperti)  );
    }
}
