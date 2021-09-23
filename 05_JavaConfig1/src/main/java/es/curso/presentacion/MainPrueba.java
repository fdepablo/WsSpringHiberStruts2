package es.curso.presentacion;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.cfg.ConfiguracionSpring;
import es.curso.modelo.entidad.Director;
import es.curso.modelo.entidad.Pelicula;

public class MainPrueba {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = 
				new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		/*
		DefaultListableBeanFactory dbf = 
				context.getBean("defaultListableBeanFactory",DefaultListableBeanFactory.class);
		dbf.setAllowBeanDefinitionOverriding(false);*/
		
		System.out.println("Arrancado");
		
		Director director1 = context.getBean("directorBean",Director.class);
		System.out.println(director1);
		
		Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
		System.out.println(pelicula);
	}

}
