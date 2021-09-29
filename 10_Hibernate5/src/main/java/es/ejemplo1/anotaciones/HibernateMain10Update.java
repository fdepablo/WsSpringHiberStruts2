package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain10Update {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Terence Hill");
		p1.setEdad(69);
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		//Aquí tenemos significativas diferencias con respecto a merge, las
		//más importantes
		//1. Siempre hace update, con independencia de si ha cambiado o no
		//2. No se trae el objeto a la cache mediante un select
		//3. El objeto que le pasamos pasa a estar cacheado, en merge era el objeto
		//que nos devolvia
		session.update(p1);
		System.out.println("Esta p1 en la cache? " + session.contains(p1));
		tx.commit();
		
		session.get(Persona.class, 1);//no hacemos select
		System.out.println(p1);
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
