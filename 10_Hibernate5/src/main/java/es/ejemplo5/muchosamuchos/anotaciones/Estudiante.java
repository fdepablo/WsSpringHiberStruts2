/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo5.muchosamuchos.anotaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
    //Aqui al igual que en onetomany debemos de elegir un dueño de la relacion
    //como ambas partes son muchos podemos elegir la que queramos
    //en este caso elegimos asignaturas como la dueña
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "listaEstudiantes")
    List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }
    
    public void addAsignatura(Asignatura asignatura){
        this.listaAsignaturas.add(asignatura);
        asignatura.addEstudiante(this);
    }
  
}
