package es.curso.modelo.negocio;

import java.util.List;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.DaoPelicula;

public class GestorPelicula {
	
	private DaoPelicula daoPelicula;
	
	/**
	 * Metodo que persiste una pelicula. La pelicula debe de tener un titulo
	 * para poder ser insertada
	 * @param p
	 * @return 0 en caso de que la pelicula haya sido insertada, 1 en caso de
	 * que este llena la lista y 2 en caso de que la pelicula no tenga titulo
	 */
	public int insertar(Pelicula p) {
		if("".equals(p.getTitulo())) {
			return 2;
		}else {
			boolean insertada = daoPelicula.insertar(p);
			if(insertada) {
				return 0;
			}else {
				return 1;
			}
		}
	}
	
	public List<Pelicula> listar(){
		return daoPelicula.getListaPeliculas();
	}

	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	
}
