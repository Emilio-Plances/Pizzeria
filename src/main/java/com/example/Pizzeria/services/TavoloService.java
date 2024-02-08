package com.example.Pizzeria.services;

import com.example.Pizzeria.beans.Tavolo;
import com.example.Pizzeria.repositories.TavoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TavoloService {
    @Autowired
    private TavoloRepository tavoloRepository;
    public void save(Tavolo t) {
        tavoloRepository.save(t);
    }
    public Tavolo searchById(int id) {
        return tavoloRepository.findById(id).get();
    }
    public void delete(int id) {
        tavoloRepository.deleteById(id);
    }
}
