package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain06Save {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");

		Persona p1 = new Persona();
		//p1.setId(0); No establecemos id porque lo generara automaticamente
		p1.setNombre("Bud Spencer");
		p1.setEdad(78);
        
		System.out.println(p1.getId());//0
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		//Devuelve el id de la persona que se dio de alta
		//a diferencia de persist() de JPA
		Integer id = (Integer)session.save(p1);
		id = (Integer)session.save(p1);//La segunda se ignora ya que esta cacheada
		
		tx.commit();
		
		//Tambien modifica el objeto pasado con el id
		System.out.println(p1.getId());//1
		System.out.println(id);//1
		
		session.close();
        Hibernate5Utils.shutdown();
	}

}
