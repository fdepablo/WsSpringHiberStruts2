package es.imprimir;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainImprimir {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		System.out.println("Crear el contexto de spring");
		context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Imprimible imp = context.getBean("modoImpresion", Imprimible.class);
		imp.imprimir("ola ke ase! :)");
	}

}
