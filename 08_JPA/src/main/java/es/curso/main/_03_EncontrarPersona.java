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
		System.out.println("Esta en la cache p1? " + em.contains(p1));
		System.out.println("Quitamos el objeto p1 de la cache");
		em.detach(p1);//Es un clear() pero solo del objeto que queramos
		System.out.println("Esta en la cache p1? " + em.contains(p1));
		p1 = em.find(Persona.class, 2);
		System.out.println("Esta en la cache p1? " + em.contains(p1));
		System.out.println(p1);
		System.out.println("Creamos una nueva persona igual que la de BBDD");
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setEdad(78);
		p2.setPeso(125);
		p2.setNombre("Bud Spencer");
		System.out.println("Esta en la cache p1? " + em.contains(p2));
		System.out.println(p2);
		
		System.out.println("Son iguales el objeto p1 y p2?");
		System.out.println(p1.equals(p2));
		
		p1 = em.find(Persona.class, 1);
		System.out.println(p1);
		em.clear();
		System.out.println("Hacemos clear, por lo que quitamos los objetos de la cache");
		p1 = em.find(Persona.class, 1);//Hariamos otra vez la consulta
		System.out.println(p1);
		
		em.close();
		
		System.out.println("Cambiamos el entity manager");
		em = emf.createEntityManager();
		p1 = em.find(Persona.class, 2);
		System.out.println(p1);
		
		emf.close();
	}

}
