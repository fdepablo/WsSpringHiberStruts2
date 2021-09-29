package es.ejemplo1.anotaciones;

import java.util.List;

import utils.Hibernate5Utils;

public class HibernateMain01 {

	public static void main(String[] args) {
		System.out.println("Arrancando");
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");
        PersonaDao personaDao = new PersonaDaoHibernate();
        
        Persona p = new Persona();
        p.setNombre("Isabel");
        p.setEdad(19);
        
        try {
			int i = personaDao.insertar(p);
			System.out.println("Valor devuelto: " + i);
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
