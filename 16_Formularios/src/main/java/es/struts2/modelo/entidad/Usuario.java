package es.struts2.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String username;
	private String password;
	private int edad;
	private String genero;
	private String lenguaje;
	private boolean compartir;
	private List<String> listaHobbies;

	public Usuario() {
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<String> getListaHobbies() {
		return listaHobbies;
	}

	public void setListaHobbies(List<String> listaHobbies) {
		this.listaHobbies = listaHobbies;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public boolean isCompartir() {
		return compartir;
	}

	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", username=" + username + ", password=" + password + ", edad=" + edad
				+ ", genero=" + genero + ", lenguaje=" + lenguaje + ", compartir=" + compartir + ", listaHobbies=" + listaHobbies
				+ "]";
	}
}