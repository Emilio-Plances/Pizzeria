package com.example.Pizzeria.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pizza {
    private String nome;
    private int calorie=1000;
    private List<Aggiunta> aggiunte=new ArrayList<>();
    private double prezzo;
    private double prezzoXL;

    public void addAggiunta(Aggiunta a){
        aggiunte.add(a);
        sumCalorie();
    }
    public void sumCalorie(){
        aggiunte.forEach(el->calorie+=el.getCalorie());
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
        prezzoXL=this.prezzo+4.0;
    }
}
