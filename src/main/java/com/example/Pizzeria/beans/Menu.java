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
    public void stampa(){
        System.out.println("Pizze:\n");
        listaPizze.forEach(el->{
            System.out.print("-"+el.getNome());
            System.out.print("    Prezzo: "+el.getPrezzo()+ "€    Prezzo XL: "+el.getPrezzoXL());
            System.out.print("€\nIngredienti:");
            el.getAggiunte().forEach(agg-> System.out.print(" "+agg.getNome()));
            System.out.print("\nCalorie: "+el.getCalorie()+"\n\n");
        });
        System.out.println("Bevande:\n");
        listaBevande.forEach(el->{
            System.out.print("-"+el.getNome());
            System.out.print("    Prezzo: "+el.getPrezzo());
            System.out.print("€\nCalorie: "+el.getCalorie()+"\n\n");
        });
        System.out.println("Aggiunte:\n");
        listaAggiunte.forEach(el->{
            System.out.print("-"+el.getNome());
            System.out.print("    Prezzo: "+el.getPrezzo());
            System.out.print("€\nCalorie: "+el.getCalorie()+"\n\n");
        });
    }
}
