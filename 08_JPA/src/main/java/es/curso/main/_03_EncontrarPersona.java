package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _03_EncontrarPersona {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		//Si no vamos a cambiar la BBDD, es decir, si no hacemos inserts, updates
		//o detetes, no tenemos la obligacion de abrir transaccionalidad

		Persona p1 = em.find(Persona.class, 2);
		System.out.println(p1);
		p1 = em.find(Persona.class, 2);
		System.out.println(p1);
		
		p1 = em.find(Persona.class, 1);
		System.out.println(p1);
		
		em.close();
		emf.close();
	}

}
