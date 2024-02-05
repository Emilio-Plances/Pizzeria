package com.example.Pizzeria.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Pizza extends Prodotto{
    private List<Aggiunta> aggiunte=new ArrayList<>();
    private double prezzoXL;

    public void addAggiunta(Aggiunta a){
        aggiunte.add(a);
        sumCalorie();
        setPrezzo();
    }
    public void sumCalorie(){
       setCalorie(aggiunte.stream().mapToInt(Aggiunta::getCalorie).reduce(1000, Integer::sum)) ;
    }

    public void setPrezzo() {
        setPrezzo(aggiunte.stream().mapToDouble(Aggiunta::getPrezzo).reduce(4.3, Double::sum));
        prezzoXL=getPrezzo()+4.0;
    }
}
