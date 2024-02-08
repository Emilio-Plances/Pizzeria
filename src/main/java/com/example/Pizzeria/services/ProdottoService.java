package com.example.Pizzeria.services;

import com.example.Pizzeria.beans.Pizza;
import com.example.Pizzeria.beans.Prodotto;
import com.example.Pizzeria.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;
    public void save(Prodotto p) {
        prodottoRepository.save(p);
    }
    public Prodotto searchById(int id) {
        return prodottoRepository.findById(id).get();
    }
    public void delete(int id) {
        prodottoRepository.deleteById(id);
    }
    public Prodotto findByName(String name){
        return prodottoRepository.findFirstByNome(name);
    }
    public List<Prodotto> findOverCalories(int calories){
        return prodottoRepository.findUnderCalories(calories);
    }
    public List<Pizza> findPizzaUnderPrezzo(int prezzo){
        return prodottoRepository.findPizzaUnderPrezzo(prezzo);
    }
}