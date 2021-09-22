package es.juego;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainVideojuego {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Guerrero g1 = context.getBean("g1",Guerrero.class);
		g1.atacar();
		Guerrero g2 = context.getBean("g2",Guerrero.class);
		g2.atacar();	
	}
}
