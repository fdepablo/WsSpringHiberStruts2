package es.juego;

public class Guerrero {
	private String nombre;
	private Arma arma;
	
	public void atacar() {
		System.out.println("Me llamo " + nombre + " y voy atacar");
		System.out.println("Argggggg!!!");
		arma.usar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
}
