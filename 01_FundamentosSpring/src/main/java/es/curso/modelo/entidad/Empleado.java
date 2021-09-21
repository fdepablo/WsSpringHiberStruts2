package es.curso.modelo.entidad;

public class Empleado {
	private String dni;
	private Direccion direccion;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", direccion=" + direccion + "]";
	}	
}
