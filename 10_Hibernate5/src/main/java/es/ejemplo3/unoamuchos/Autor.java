/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo3.unoamuchos;

import java.util.HashSet;
import java.util.Set;

import es.ejemplo2.unoauno.Persona;


public class Autor extends Persona{
    
    private Set<Libro> conjuntoLibros = new HashSet<Libro>();
    
    public Autor(){
        super();
    }

    public Set<Libro> getConjuntoLibros() {
        return conjuntoLibros;
    }

    public void setConjuntoLibros(Set<Libro> conjuntoLibros) {
        this.conjuntoLibros = conjuntoLibros;
    }
    
    public void addLibro(Libro libro){
        conjuntoLibros.add(libro);
    }

	@Override
	public String toString() {
		return "Autor [conjuntoLibros=" + conjuntoLibros + ", getId()="
				+ getId() + ", getNombre()=" + getNombre() + ", getEdad()="
				+ getEdad() + "]";
	}
    
    
}
