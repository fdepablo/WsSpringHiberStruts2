package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _06_BorrarPersona {
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Persona p1 = em.find(Persona.class, 1);
		
		em.remove(p1);
		
		et.commit();
		
		System.out.println("Persona borrada");
		
		em.close();
		emf.close();
	}
}
