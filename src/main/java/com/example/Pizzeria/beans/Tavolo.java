package com.example.Pizzeria.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Data
public class Tavolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="max_coperti")
    private int maxCoperti;
    @Enumerated(EnumType.STRING)
    @Column (name="stato_tavolo")
    private StatoTavolo statoTavolo;
    @OneToMany(mappedBy = "tavolo")
    private List<Ordine> listaOrdini=new ArrayList<>();
}
