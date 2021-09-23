package es.curso.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//En Spring tenemos 4 anotaciones basicas para dar de alta objetos
//en el contexto de spring

//@Component
//@Service
//@Repository
//@Controller (usado para Spring MVC)

//Las cuatro anotaciones hacen en principio exactamente lo mismo, que es dar de
//alta objetos. Simplemente el significado de lo que hace cada una es puramente
//semantico.

//Poner @Component seria equivalente a la siguiente sentencia
//por defecto, spring da de alta el objeto en el contexto con el id
//igual al nombre de la clase en notacion lowerCamelCase
//<bean id="director" class="es.curso.modelo.entidad.Director"></bean>
@Component(value="directorBean")
//<bean id="directorBean" class="es.curso.modelo.entidad.Director"></bean>
@Scope("prototype")
//<bean id="directorBean" class="es.curso.modelo.entidad.Director" scope="prototype">
//</bean>
public class Director{
	private int id;
	private String nombre;
	
	public Director() {
		this.id = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + "]";
	}	
}
