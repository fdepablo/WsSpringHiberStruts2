package es.main;

import es.modelo.entidad.Persona;

public class Main {

	//Punto de entrada de ejecucion
	public static void main(String[] args) {
		System.out.println("Incio de un programa java");
		
		//El ciclo de vida de un objeto en java es que estara vivo mientras
		//tenga una referencia apuntadole
		Persona p = new Persona();
		//En java existe un software llamada "recolector de basura" el cual
		//borra aquellos objetos que estan desreferenciados
		
		//El cliclo de vida de una referencia es desde donde se crea hasta el 
		//final del bloque (los bloques vienen representados por llaves "{}"
		Persona p2 = crearObjeto();
		System.out.println("Se ha creado el objeta");
		System.out.println(p2);
		
		Persona p3 = new Persona();
		p3.setEdad(55);
		
		p2 = p3;
		
		System.out.println(p2);//40 55 55
		System.out.println(p3);//55 40 55
	}
	
	public static Persona crearObjeto() {
		//En java los objetos son anonimos, es decir no tienen identificador
		//ni nombre
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Steve Rogers");
		p1.setEdad(40);
		return p1;
	}

}
