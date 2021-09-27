package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _01_PruebaConexion {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
}
