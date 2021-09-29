/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo5.muchosamuchos;

import java.util.HashSet;
import java.util.Set;

import es.ejemplo2.unoauno.Persona;


public class Estudiante extends Persona {
    
    Set<Asignatura> conjuntoAsignaturas = new HashSet<Asignatura>();

    public Set<Asignatura> getConjuntoAsignaturas() {
        return conjuntoAsignaturas;
    }

    public void setConjuntoAsignaturas(Set<Asignatura> conjuntoAsignaturas) {
        this.conjuntoAsignaturas = conjuntoAsignaturas;
    }
    
    public void addAsignatura(Asignatura asignatura){
        this.conjuntoAsignaturas.add(asignatura);
    }
}
