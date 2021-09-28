package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _07_ActualizacionPersona {
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		Persona p1 = em.find(Persona.class, 3);
		p1.setEdad(85);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(p1);
		
		et.commit();
		
		em.close();
		emf.close();
	}
}
