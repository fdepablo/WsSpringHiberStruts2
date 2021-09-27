package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Persona;

public class _02_CrearPersona {
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		
		Persona p1 = new Persona();
		//p1.setId(0); No establecemos id porque lo generara automaticamente
		p1.setNombre("Bud Spencer");
		p1.setEdad(78);
		p1.setPeso(125);
		
		System.out.println(p1.getId());//0
		//Siempre que queramos cambiar nuestra BBDD debemos de trabajar en un 
		//contexto de transaccionalidad
		EntityTransaction et = em.getTransaction();
		et.begin();//a partir de aqui todas las operaciones seran atomicas
		
		//Mediante persit() declamos la intencion de persistir el objeto en 
		//BBDD, pero ojo, es solo intencion, si queremos realmente persistirlo
		//debemos decirselo.
		em.persist(p1);
		//em.persist(p1);//La segunda se ignora
		
		//Para sincronizar todos los objetos que tengo cacheados en memoria con la
		//BBDD podemos ejecutar un commit()
		et.commit();
				
		System.out.println(p1.getId());
		
		/*
		 * Si queremos garantizarnos que no haya objetos cacheados por el
		 * Entity Manager, podemos o crear un nuevo entity manager o usar
		 * la funcion clear() para quitar los objetos gestionados
		et = em.getTransaction();
		et.begin();
		//em.clear();//limpiando el entity manager
		et.commit();*/
		
		em.close();		
		emf.close();
	}
}
