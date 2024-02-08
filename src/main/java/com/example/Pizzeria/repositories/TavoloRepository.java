package com.example.Pizzeria.repositories;

import com.example.Pizzeria.beans.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TavoloRepository extends JpaRepository<Tavolo,Integer> {}