package es.struts2.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.struts2.modelo.entidad.Empleado;
import es.struts2.modelo.persistencia.DaoEmpleado;

@Service
public class GestorEmpleado {

	@Autowired
	private DaoEmpleado daoEmpleado;
	
	//En spring creamos la transaccionalida en el gestor, y es obligatoria
	//para todos los metodos (tambien para las busquedas)
	@Transactional
	public Empleado buscar(int id) {
		Empleado e = daoEmpleado.buscar(id);
		return e;
	}
	
	@Transactional
	public int alta(Empleado e) {
		return daoEmpleado.alta(e);
	}
	
	@Transactional
	public void modificar(Empleado e) {
		daoEmpleado.modificar(e);
	}
	
	@Transactional
	public void borrar(int id) {
		daoEmpleado.borrar(id);
	}
	
	@Transactional
	public List<Empleado> listar(){
		return daoEmpleado.listar();
	}
	
}
