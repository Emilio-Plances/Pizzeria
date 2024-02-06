package com.example.Pizzeria.beans;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Tavolo {
    private int id;
    private int maxCoperti;
    private StatoTavolo statoTavolo;
}
