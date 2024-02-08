package com.example.Pizzeria.beans;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aggiunta extends Prodotto{
    @ManyToMany
    @JoinTable(
            name = "aggiunta_pizza",
            joinColumns = @JoinColumn(name = "aggiunta_fk"),
            inverseJoinColumns = @JoinColumn(name = "pizza_fk")
    )
    List<Pizza> listaPizze=new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
}
