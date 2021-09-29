package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain09Merge {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Terence Hill");
		p1.setEdad(58);
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		Persona p2 = (Persona) session.merge(p1);
		//System.out.println(session.isDirty());
		boolean igual = p2.equals(p1);
		
		System.out.println("Esta p1 en la cache? " + session.contains(p1));
		
		tx.commit();
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
