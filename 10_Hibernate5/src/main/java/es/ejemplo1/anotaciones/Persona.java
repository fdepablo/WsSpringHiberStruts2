package es.ejemplo1.anotaciones;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//Indicamos que esta clase es una entidad a ser persistida
@Entity
//Si queremos cambiarle el nombre a la tabla
@Table(name="personas")
public class Persona {
	//Creamos un ID para que se genere automaticamente
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//Podemos cambiarle el nombre a la columna
	@Column(name="nombre")
	private String nombre;
	//Por defecto se mapean todas las propiedades
	//Si no queremos alguna podmeos hacerlo con la anotacion
	//@Transient
	private int edad;
	
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(edad, id, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && id == other.id && Objects.equals(nombre, other.nombre);
	}
		
	
}
