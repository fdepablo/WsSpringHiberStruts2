package es.curso.presentacion;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.cfg.ConfiguracionSpring;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;

public class MainCapas {

	public static ApplicationContext context;
	
	public static void main(String[] args) {		
		context = 
				new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		System.out.println("Arrancando!");
		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		
		do {
			System.out.println("Introduzca el titulo, el genero y el nombre del director");
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String director = sc.nextLine();
			
			Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			pelicula.getDirector().setNombre(director);
			
			GestorPelicula gp = context.getBean("gestorPelicula",GestorPelicula.class);
			int resultado = gp.insertar(pelicula);
			if(resultado == 0) {
				System.out.println("Pelicula insertada");
			}else if(resultado == 1) {
				System.out.println("Lista llena!");
			}else {
				System.out.println("La pelicula debe de tener un titulo!");
			}
			
			System.out.println(gp.listar());
			System.out.println("Desea continuar?");
			continuar = sc.nextLine();
		}while("s".equalsIgnoreCase(continuar));
		
		System.out.println("Fin de programa");
	}

}
