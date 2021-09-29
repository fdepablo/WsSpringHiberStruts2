package es.ejemplo1.anotaciones;

import java.util.List;

import utils.Hibernate5Utils;

public class HibernateMain04 {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");

        PersonaDao personaDao = new PersonaDaoHibernate();
        
        Persona p = new Persona();
        p.setId(1);
        
        try {
			personaDao.borrar(p);
		} catch (Exception e) {
			System.out.println("Error insertando usuario " + e.getMessage());
			e.printStackTrace();
		}
        
        List<Persona> listaPersonas = personaDao.getLista();
        
        for(Persona persona : listaPersonas){
            System.out.println(persona.getId() + " " + persona.getNombre() + " "
            + persona.getEdad());
        }
        
        Hibernate5Utils.shutdown();
	}

}
