package es.curso.modelo.entidad;

//Para utilizar un objeto en el contexto de spring es muy recomendable
//que siga la convencion POJO
public class Persona {
	private int id;
	private String nombre;
	private int edad;
	
	//En java si no creamos constructor, java nos crea el constructor
	//vacio por defecto
	
	public Persona() {
		super();
	}
	
	public Persona(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
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
