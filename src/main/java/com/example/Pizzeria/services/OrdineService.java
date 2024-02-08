package com.example.Pizzeria.services;

import com.example.Pizzeria.beans.Ordine;
import com.example.Pizzeria.repositories.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    public void save(Ordine o){
        ordineRepository.save(o);
    }
    public Ordine searchById(int id){
        return ordineRepository.findById(id).get();
    }
    public void delete(int id){
        ordineRepository.deleteById(id);
    }
}
