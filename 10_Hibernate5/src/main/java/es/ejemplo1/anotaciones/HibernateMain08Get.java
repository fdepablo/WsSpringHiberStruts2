package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;

import utils.Hibernate5Utils;

public class HibernateMain08Get {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
		
		Session session = Hibernate5Utils.getSessionFactory().openSession();
		
		Persona p1 = session.get(Persona.class, 1);
		System.out.println(p1);
		System.out.println("Esta en la cache p1? " + session.contains(p1));
		System.out.println("Quitamos el objeto p1 de la cache");
		session.evict(p1);//Es un clear() pero solo del objeto que queramos
		System.out.println("Esta en la cache p1? " + session.contains(p1));
		p1 = session.get(Persona.class, 1);
		System.out.println("Esta en la cache p1? " + session.contains(p1));
		System.out.println(p1);
		
		System.out.println("Buscamos otra vez el objeto cacheado (no query)");
		p1 = session.get(Persona.class, 1);
		System.out.println(p1);
		session.clear();
		System.out.println("Hacemos clear, por lo que quitamos los objetos de la cache");
		p1 = session.get(Persona.class, 1);//Hariamos otra vez la consulta
		System.out.println(p1);
		
		session.close();
		
		System.out.println("Cambiamos el objeto de session, la cache es diferente");
		session = Hibernate5Utils.getSessionFactory().openSession();
		p1 = session.get(Persona.class, 1);
		System.out.println(p1);
		
		System.out.println("Buscamos una persona que no existe");
		p1 = session.get(Persona.class, 2);
		System.out.println(p1);
        Hibernate5Utils.shutdown();
	}

}
