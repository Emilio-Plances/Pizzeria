package com.example.Pizzeria.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Pizza extends Prodotto{
    @ManyToMany(mappedBy = "listaPizze")
    private List<Aggiunta> listaAggiunte=new ArrayList<>();
    private double prezzoXL;

    public void addAggiunta(Aggiunta a){
        listaAggiunte.add(a);
        sumCalorie();
        setPrezzo();
    }
    public void sumCalorie(){
       setCalorie(listaAggiunte.stream().mapToInt(Aggiunta::getCalorie).reduce(1000, Integer::sum)) ;
    }

    public void setPrezzo() {
        setPrezzo(listaAggiunte.stream().mapToDouble(Aggiunta::getPrezzo).reduce(4.3, Double::sum));
        prezzoXL=getPrezzo()+4.0;
    }
    public String toString(){
        return super.toString()+
                ", prezzo XL= "+prezzoXL;
    }
}
