package com.example.Pizzeria.repositories;

import com.example.Pizzeria.beans.Bevanda;
import com.example.Pizzeria.beans.Pizza;
import com.example.Pizzeria.beans.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Integer> {
    public Prodotto findFirstByNome(String nome);

    @Query("SELECT p FROM Prodotto p WHERE p.calorie<:calories")
    public List<Prodotto> findUnderCalories(int calories);

    @Query("SELECT p FROM Pizza p WHERE p.prezzo<:prezzo")
    public List<Pizza> findPizzaUnderPrezzo(int prezzo);
}
