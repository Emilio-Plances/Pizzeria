package com.example.Pizzeria;

import com.example.Pizzeria.beans.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		Menu m=ctx.getBean(Menu.class);

		System.out.println("Pizze:\n");
		m.getListaPizze().forEach(el->{
			System.out.print("-"+el.getNome());
			System.out.print("    Prezzo: "+el.getPrezzo());
			System.out.print("€\nIngredienti:");
			el.getAggiunte().forEach(agg-> System.out.print(" "+agg.getNome()));
			System.out.print("\nCalorie: "+el.getCalorie()+"\n\n");
		});

		System.out.println("Bevande:\n");

		m.getListaBevande().forEach(el->{
			System.out.print("-"+el.getNome());
			System.out.print("    Prezzo: "+el.getPrezzo());
			System.out.print("\nCalorie: "+el.getCalorie()+"\n\n");
		});

		System.out.println("Aggiunte:\n");

		m.getListaAggiunte().forEach(el->{
			System.out.print("-"+el.getNome());
			System.out.print("    Prezzo: "+el.getPrezzo());
			System.out.print("\nCalorie: "+el.getCalorie()+"\n\n");
		});
	}

}
