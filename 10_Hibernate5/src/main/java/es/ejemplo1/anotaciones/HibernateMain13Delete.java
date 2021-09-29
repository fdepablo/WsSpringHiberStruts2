package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain13Delete {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Persona p1 = new Persona();
		p1.setId(2);
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		//El delete funciona igual que el remove() en hibernate
		session.delete(p1);
		
		tx.commit();
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
