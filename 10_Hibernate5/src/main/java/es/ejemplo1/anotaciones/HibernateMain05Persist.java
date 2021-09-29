package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain05Persist {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");

		Persona p1 = new Persona();
		//p1.setId(0); No establecemos id porque lo generara automaticamente
		p1.setNombre("Bud Spencer");
		p1.setEdad(78);
        
		System.out.println(p1.getId());//0
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(p1);
		session.persist(p1);//La segunda se ignora ya que esta cacheada
		
		tx.commit();
		
		System.out.println(p1.getId());//1
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
