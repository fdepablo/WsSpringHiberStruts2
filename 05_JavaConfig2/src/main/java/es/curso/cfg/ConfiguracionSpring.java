package es.curso.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.curso.modelo.entidad.Director;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;
import es.curso.modelo.persistencia.DaoPelicula;

//Esta clase es la que vamos a usar para dar de alta nuestros objetos y para
//decirle a Spring que busque anotaciones en nuestro proyecto

//Para decirle a Spring que esta clase va a ser una clase de configuración
//usaremos la anotacion @Configuration

@Configuration
public class ConfiguracionSpring {
	
	//Cuando arrancamos una aplicacion mediante una clase anotada con @Configuration
	//podemos dentro de la clase dar de alta todos los bean que queramos.
	//La manera básica de proceser sería mediante metodos anotados con @Bean
	
	//Por supuesto podemos seguir mezclando el dar de alta objetos mediante anotaciones
	//con dar de alta objetos dentro de la clase de configuracion
	
	/*
	 * El tipo de retorno sera el tipo del objeto que daremos de alta en el contexto
	 * de Spring
	 * El nombre del metodo sera el id con que demos de alta el objeto en spring
	 * Podemos cambiar el scope de los objetos creados, por defecto seran de tipo
	 * singleton. Para cambiarlo usaremos la etiqueta @Scope
	 * Podemos cambiar el id por defecto que le da spring
	 */
	@Bean(value="directorBean")
	@Scope("prototype")
	public Director director() {
		Director director = new Director();
		director.setId(10);
		return director;
	}
	
	@Bean(value="directorBean2")
	@Scope("prototype")
	public Director director2() {
		Director director = new Director();
		director.setId(20);
		return director;
	}
	
	//En nuestro esquema la pelicula tiene una dependencia con director
	//Por lo que queremos que la pelicula ya venga inyectada con el objeto
	//director correspondiente
	//Podemos hacer dos cosas:
	//1. Dentro del mismo metodo, crear el objeto director e inyectarselo
	//2. Diciendole al contexto de spring que nos pase un objeto director
	//que este dado de alta en el contexto. Para ello simplemente tenemos
	//que pasarle un parametro de entrada al metodo del tipo de dato que 
	//queramos
	//En el caso de tengamos dentro del contexto de spring 2 o mas beans
	//del tipo que queremos inyectar, para evitar esta duda podemos utilzar
	//la anotacion @Qualifier
	@Bean
	@Scope("prototype")
	public Pelicula pelicula(@Qualifier("directorBean2") Director director) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("");
		pelicula.setDirector(director);
		return pelicula;
	}
	
	
	@Bean
	public DaoPelicula daoPelicula() {
		DaoPelicula daoPelicula = new DaoPelicula();
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		daoPelicula.setListaPeliculas(listaPelicula);
		daoPelicula.setNumeroMaximoPelicula(3);
		return daoPelicula;
	}
	
	@Bean
	public GestorPelicula gestorPelicula(DaoPelicula daoPelicula) {
		GestorPelicula gestorPelicula = new GestorPelicula();
		gestorPelicula.setDaoPelicula(daoPelicula);
		return gestorPelicula;
	}
}
