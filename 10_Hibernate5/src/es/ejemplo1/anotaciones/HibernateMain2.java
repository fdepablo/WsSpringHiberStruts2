package es.ejemplo1.anotaciones;

import utils.Hibernate5Utils;


public class HibernateMain2 {

	public static void main(String[] args) {
		Hibernate5Utils.setFichero("es/ejemplo1/anotaciones/hibernate.cfg.xml");

        PersonaDao personaDao = new PersonaDaoHibernate();
                
        try {
        	Persona p = personaDao.get(1);
        	System.out.println(p);
		} catch (Exception e) {
			System.out.println("Error insertando usuario " + e.getMessage());
			e.printStackTrace();
		}
        
        Hibernate5Utils.shutdown();
	}

}
