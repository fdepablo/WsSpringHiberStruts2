package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain11Buscar {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
	
		//En hibernate el alias no es obligatorio, esto sería HQL
		List<Persona> listaPersonas = session.createQuery("from Persona").getResultList();
		
		System.out.println(listaPersonas);
		
		//Pero sigue aceptando consultas JPQL, las consultas JPQL son validas en Hibernate
		//pero no tienen porque serlo a la inversa
		listaPersonas = session.createQuery("from Persona p").getResultList();
		
		System.out.println(listaPersonas);
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
