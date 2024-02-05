package com.example.Pizzeria.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    List<Pizza> listaPizze=new ArrayList<>();
    List<Bevanda> listaBevande=new ArrayList<>();
    List<Aggiunta> listaAggiunte=new ArrayList<>();

    public void addPizza(Pizza p){
        listaPizze.add(p);
    }
    public void addBevanda(Bevanda b){
        listaBevande.add(b);
    }
    public void addAggiunta(Aggiunta a){
        listaAggiunte.add(a);
    }
}
