package es.ejemplo2.unoauno.anotaciones;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String nombre;
	private Integer edad;
	
	//Ponemos el tipo de relacion que tiene con direccion. En caso de que
	//hagamos algun tipo de cambio en la persona (como borrar la persona,
	//darla de alta o modificarla, tambien deberemos de hacerlo con Direccion)
	//Funciona igual que las anotaciones de JPA
	@OneToOne(cascade=CascadeType.ALL) 
	private Direccion direccion;
	
	
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", direccion=" + direccion + "]";
	}
		
	
}
