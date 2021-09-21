package es.imprimir;

public class ImprimirPantalla implements Imprimible {

	@Override
	public void imprimir(String frase) {
		System.out.println(frase);	
	}
	
}
