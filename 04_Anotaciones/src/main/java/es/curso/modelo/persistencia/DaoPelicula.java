package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Pelicula;

@Repository
public class DaoPelicula {

	@Autowired
	@Qualifier("listaPe")
	private List<Pelicula> listaPeliculas;
	@Autowired
	private int numeroMaximoPelicula;
	
	//Esto seria un comentario javadoc
	/**
	 * Metodo que inserta una pelicula y la guarda
	 * @param p representa la pelicula que queremos insertar
	 * @return <b>true</b> en caso de que la pelicula haya sido insertada y <b>false</b>
	 * en caso de que la lista este llena y no haya sido posible insertarla
	 */
	public boolean insertar(Pelicula p) {
		/*
		 * comparamos el tama?o de la lista con el maximo numero de peliculas
		 */
		if(listaPeliculas.size() >= numeroMaximoPelicula) {
			return false;
		}else {
			listaPeliculas.add(p);
			return true;
		}
	}
	
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}	
}
