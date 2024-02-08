package com.example.Pizzeria.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private int calorie;
    private double prezzo;
    @ManyToMany
    @JoinTable(
            name="ordine_prodotto",
            joinColumns = @JoinColumn(name="ordine_fk"),
            inverseJoinColumns = @JoinColumn(name="prodotto_fk")
    )
    private List<Ordine> listaOrdini;

    public String toString(){
        return  "id= "+id+
                ", nome= "+nome+
                ", calorie= " +calorie+
                ", prezzo= "+prezzo;
    }
}
