package es.imprimir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImprimirFichero implements Imprimible{
	
	/*
	 * Para sobreescribir un metodo en java tiene que tener la misma
	 * firma que el metodo padre.
	 * 
	 * La firma se compone de 3 conceptos:
	 * 
	 *  1- el nombre del metodo
	 *  2- el numero de parametros de entrada del metodo
	 *  3- el mismo tipo de parametros de entrada del metodo
	 *  
	 *  En el caso de las interfaces tambien el tipo de retorno debe ser
	 *  el mismo
	 */
	public void imprimir(String frase) {
		File file = new File("fichero.txt");		
		//En java existe lo que se conocen los bloques try/catch autoclosable
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(frase);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//en cuanto salgamos del bloque try/catch se autocierra el fichero
	}
}
