package es.curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Poniendo esta entidad sera una entidad gestionda por el entity manager y por defecto
//cogera el nombre de la clase como nombre de la tabla y sus atributos como campos
@Entity
@Table(name = "personas")//cambiamos el nombre de la tabla
public class Persona {
	@Id
	//Con esto hacemos que le id sea autogenerado por la BBDD e incrementar
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre_usuario")
	private String nombre;
	private int edad;
	private double peso;
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}		
}
