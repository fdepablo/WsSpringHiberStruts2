/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo3.unoamuchos.anotaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="autores")
public class Autor{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	//En relaciones "@OneToMany" es importante qui�n es el due�o de la 
	//relaci�n, ya que es el due�o quien determina como debe actuar
	//el el motor de persistencia

	//El due�o SIEMPRE esta en el lado muchos, es decir, quien tiene la FK. 
	//Por lo que en este caso el due�o de la relaci�n es la clase "Libro".
	//viene representado por el elemento 'mappedBy' y hace referencia a la 
	//propiedad 'autor' que esta en la clase libro
	
	//El elemento fetch hacer referencia al modo en que queremos cargar los
	//elementos libros cuando nos traigamos el autor
	//FetchType.LAZY, lo que realmente nos traeremos son objetos 'proxy', no
	//nos traeremos la lista de libros reales, cuando accedamos a alguno de esos
	//libros sera cuando le digamos a hibernate que vaya a BD a por ellos
	//FetchType.EAGER, nos traeremos toda la lista de libros reales, el problema
	//es que si la lista es muy grande podemos ocupar mucha memoria
	
	//Por defecto el fetch en las relaciones oneToMay es LAZY mientras que en las
	//relaciones oneToOne es EAGER
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="autor")
    private List<Libro> listaLibros = new ArrayList<Libro>();
    
	public Autor(){
        super();
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}


	public void addLibro(Libro libro){
    	listaLibros.add(libro);
    	//Ponemos esto para que libro apunte a este autor
    	libro.setAutor(this);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", conjuntoLibros=" + listaLibros
				+ "]";
	}   
    
}
