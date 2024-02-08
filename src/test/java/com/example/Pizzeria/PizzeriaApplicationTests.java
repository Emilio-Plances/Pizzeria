package com.example.Pizzeria;

import com.example.Pizzeria.beans.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PizzeriaApplicationTests {

	static AnnotationConfigApplicationContext ctx;
	@Autowired
	private PizzeriaApplication controller;
	@BeforeAll
	static void accediAlContesto(){
		ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);
	}
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	@Test
	void esisteOrdine(){
		Ordine o=ctx.getBean("ordine1",Ordine.class);
		assertThat(o).isNotNull();
	}
	@Test
	void esisteTavoloAssociato(){
		Ordine o=ctx.getBean("ordine1",Ordine.class);
		Tavolo t=ctx.getBean("tavolo",Tavolo.class);
		Assertions.assertEquals(t,o.getTavolo());
	}
	@Test
	void esistePizzaMargheritaConMozzarella(){
		Menu m= ctx.getBean(Menu.class);
		Aggiunta a= ctx.getBean("mozzarella",Aggiunta.class);

		Pizza pizza= m.getListaPizze().stream().filter(el->el.getNome().equals("Margherita")).toList().getFirst();
		Assertions.assertAll(
				()->assertThat(pizza).isNotNull(),
				()->Assertions.assertTrue(pizza.getListaAggiunte().contains(a))
		);
	}
	@ParameterizedTest
	@ValueSource(strings = {"Mozzarella","Ananas"})
	void esistonoMozzarellaPomodoro(String s){
		Menu m= ctx.getBean(Menu.class);
		Aggiunta a= m.getListaAggiunte().stream().filter(el->el.getNome().equals(s)).toList().getFirst();
		assertThat(a).isNotNull();
	}

	@AfterAll
	static void closeContext(){
		ctx.close();
	}
}
