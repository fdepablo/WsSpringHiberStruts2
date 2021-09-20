package es.modelo.entidad;

//Normalmente las clases que representan entidades en java llevan un estructura
//llamada JavaBean, esto es, atributos privados y setters y getters publicos
// Ej: id -> setId -> getId
public class Persona {
	
	private int id;
	private String nombre;
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
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
}
