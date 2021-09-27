package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _04_ModificarPersona {
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		Persona p1 = new Persona();
		p1.setId(2);
		p1.setNombre("Terence Hill");
		p1.setEdad(59);
		p1.setPeso(69);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		//El metodo merge crea un objeto a imagen y semejanza del que le pasemos
		//pero es diferente el objeto!!!
		//El metodo te devuelve una refencia del objeto gestionado por el 
		//contexto de persistencia
		em.merge(p1);
		System.out.println("Esta p1 en la cache? " + em.contains(p1));
		//p1.setPeso(79);
		et.commit();
		
		em.close();
		emf.close();
	}
}
