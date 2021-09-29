/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo1.anotaciones;

import java.util.List;


public interface PersonaDao {
    public Integer insertar(Persona persona);
    public Persona get(int i);
    public void actualizar(Persona persona);
    public void borrar(Persona persona);
    //Hasta aqui un tipico CRUD (Create, Read, Update y Delete)
    public List<Persona> getLista();
}
