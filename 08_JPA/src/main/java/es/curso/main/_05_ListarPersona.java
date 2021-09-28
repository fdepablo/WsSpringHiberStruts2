package es.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _05_ListarPersona {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		//Para hacer queries en JPA o en Hibernate usaremos un lenguaje 
		//de consultas que sera JPQL para JPA o HQL para Hibernate. Toda
		//consulta hecha en JPQL valdra para hibernate, pero a la inversa
		//pueda fallar. Este tipo de consultas siempre trabaja con clases
		//y no con tablas de bbdd
		List<Persona> listaPersonas = em.createQuery("from Persona p").getResultList();
		
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
				
		em.close();
		emf.close();
	}

}
