package es.juego;

public class MainVideojuego {
	public static void main(String[] args) {
		Guerrero guerrero = new Guerrero();
		guerrero.setNombre("Conan");
		Arma espada = new Espada();
		guerrero.setArma(espada);
		guerrero.atacar();
	}
}
