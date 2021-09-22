package es.curso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.entidad.Director;
import es.curso.modelo.entidad.Empleado;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.entidad.Persona;

public class MainSpring1 {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		System.out.println("Crear el contexto de spring");
		context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Persona p1 = (Persona)context.getBean("tony");
		p1.setEdad(34);
		p1.setId(1);
		p1.setNombre("Tony Stark");
		
		Persona p = new Persona();
		p = null;
		
		p1 = null;
		
		Persona p2 = (Persona)context.getBean("tony");
		System.out.println(p2);
		p2.setEdad(42);
		
		Persona p3 = context.getBean("tony",Persona.class);
		System.out.println(p3);
		
		Persona p4 = context.getBean("steve",Persona.class);
		System.out.println(p4);
		p4.setEdad(43);
		
		Persona p5 = context.getBean("steve",Persona.class);
		System.out.println(p5);
		
		Persona p6 = context.getBean("persona",Persona.class);
		System.out.println(p6);
		p6.setNombre("Thor");
		System.out.println(p6);
		
		Persona p7 = context.getBean("persona",Persona.class);
		System.out.println(p7);
		
		//Sin ningun problema, podemos trabajar con objetos normales
		//java
		Persona p9 = new Persona();
		System.out.println(p9);
		
		accederCochesBD();
		
		Pelicula pelicula = new Pelicula();
		Director director = new Director();
		pelicula.setDirector(director);
		pelicula.setTitulo("Matrix");
		pelicula.getDirector().setNombre("Güasosky");
		System.out.println(pelicula);
		
		
		Pelicula pelicula1 = context.getBean("pelicula",Pelicula.class);
		pelicula1.setId(1);
		pelicula1.getDirector().setNombre("El director de jp");
		System.out.println(pelicula1);
		Director d = pelicula1.getDirector();
		d = context.getBean("director30",Director.class);
		
		List<Persona> listaPersonas = 
				context.getBean("listaPersonas",List.class);
		System.out.println(listaPersonas);
		
		Persona p10 = context.getBean("personaConstructor",Persona.class);
		System.out.println(p10);
		
		Pelicula peliculaInner = context.getBean("peliculaInnerBean", Pelicula.class);
		System.out.println(peliculaInner);
		
		//En version 1.5 y anteriores de java las listas eran genericas
		//ListlistaGenerica = new ArrayList();
		List<Object> listaGenerica = new ArrayList<>();
		listaGenerica.add(new Coche());
		listaGenerica.add(new Persona());
		listaGenerica.add("Esto es un string");
		
		List<Persona> listaPersonas2 = context.getBean("listaPersonas2",List.class);
		System.out.println(listaPersonas2);
		listaPersonas2.get(1).setNombre("Filemon");
		System.out.println(listaPersonas2);
		listaPersonas2.add(new Persona());
		//listaPersonas2.add(new Coche());//error
		
		Map<String, Persona> mapaPersonas = context.getBean("mapaPersonas",Map.class);
		System.out.println(mapaPersonas.get("Obelix"));
		System.out.println(mapaPersonas.get("Panoramix"));
		System.out.println(mapaPersonas.get("Asterix"));
		
		Empleado empleado = context.getBean("empleado", Empleado.class);
		System.out.println(empleado);
	}
	
	public static void accederCochesBD() {
		String query = "select * from coches";
		
		List<Coche> listaCoche = new LinkedList<>();
		
		int id = 0;
		for(int i = 0; i <= 4; i++) {
			Coche coche = context.getBean("coche", Coche.class);
			coche.setId(++id);
			listaCoche.add(coche);
		}
		
		System.out.println(listaCoche);
	}

}
