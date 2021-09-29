package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain12Remove {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Persona p1 = new Persona();
		p1.setId(1);
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		//Este cambio es significativo respecto a JPA, en hibernate no hace falta
		//tener el objeto cacheado para poder borrarlo
		session.remove(p1);
		
		tx.commit();
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
