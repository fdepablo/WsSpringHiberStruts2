package es.struts2.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import es.struts2.modelo.entidad.Empleado;
import es.struts2.modelo.negocio.GestorEmpleado;

@Controller
@Namespace(value = "/")
public class EmpleadoAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GestorEmpleado gestorEmpleado;
	
	private Integer id;
	private String nombre;
	private int edad;
	
	@Autowired
	private Empleado empleado;
	
	private List<Empleado> listaEmpleados;
	
	//Podemos poner la anotacion @Action en vez de en la clase en los metodos
	//que representarian los puntos de entrada. Con esto podemos tener
	//en una clase varias entradas en vez de solo una.
	@Action(value = "inicio", 
	results = { 
			@Result(name = "success", location = "/principal.jsp"),
	})
	public String listar() throws Exception {
		System.out.println("listar()");
		listaEmpleados = gestorEmpleado.listar();
		return SUCCESS;
	}
	
	@Action(value = "buscarEmpleado", 
			results = { 
					@Result(name = "success", location = "/busqueda.jsp"),
	})
	public String buscarEmpleado() throws Exception {
		empleado = gestorEmpleado.buscar(id);
		return SUCCESS;
	}
	
	@Action(value = "altaModificarEmpleado", 
	results = { 
			@Result(name= "success", 
					type = "redirectAction", 
					location = "inicio"),
	})
	public String altaModificarEmpleado() throws Exception {
		empleado.setNombre(nombre);
		empleado.setEdad(edad);
		System.out.println(empleado);
		if(id != null) {
			empleado.setId(id);
			gestorEmpleado.modificar(empleado);
			System.out.println("Empleado con id " + id + " modificado");
		}else {
			int id = gestorEmpleado.alta(empleado);
			System.out.println("se ha dado de alta con id: " + id);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "borrarEmpleado", 
	results = { 
			@Result(name= "success", 
					type = "redirectAction", 
					location = "inicio"),
	})
	public String borrarEmpleado() throws Exception {
		gestorEmpleado.borrar(id);
		System.out.println("Empleado con id " + id + " borrado");
		return SUCCESS;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}	
}