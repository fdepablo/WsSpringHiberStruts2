package es.struts2.modelo.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.struts2.modelo.entidad.Empleado;

//Damos de alta el objeto daoEmpleado en spring
@Repository
public class DaoEmpleado {
	
	//Inyectamos el objeto SessionFactory que dimos de alta en HibernateConf.java
	@Autowired
    private SessionFactory sessionFactory;
	
	public Empleado buscar(int id) {
		//antes utilizamos openSession(), en entornos web mejor
		//uitlizar si hubiera una session abierta
		Session s = sessionFactory.getCurrentSession();
		//Aqui no abro transaccines (en ningun metodo), ahora
		//las transacciones las va a controlar spring en los
		//objetos de negocio (gestores)
		return s.get(Empleado.class, id);
	}
	
	public int alta(Empleado e) {
		Session s = sessionFactory.getCurrentSession();
		int id = (int)s.save(e);
		return id;
	}
	
	public void modificar(Empleado e) {
		Session s = sessionFactory.getCurrentSession();
		s.update(e);
	}
	
	public void borrar(int id) {
		Session s = sessionFactory.getCurrentSession();
		Empleado e = new Empleado();
		e.setId(id);
		s.delete(e);
	}
	
	public List<Empleado> listar() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Empleado e").getResultList();
	}
	
}
