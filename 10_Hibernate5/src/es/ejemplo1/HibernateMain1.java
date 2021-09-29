package es.ejemplo1;

import java.util.List;

import utils.Hibernate5Utils;

public class HibernateMain1 {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/hibernate.cfg.xml");

        PersonaDao personaDao = new PersonaDaoHibernate();
        
        Persona p = new Persona();
        p.setNombre("Manuel");
        p.setEdad(45);
        
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
        
        //Paramos hibernate, esto solo deberia ir al final del programa
        Hibernate5Utils.shutdown();
	}

}
