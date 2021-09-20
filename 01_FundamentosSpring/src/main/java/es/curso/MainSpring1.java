package es.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	}

}
