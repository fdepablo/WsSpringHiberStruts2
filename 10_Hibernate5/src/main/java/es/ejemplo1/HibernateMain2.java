package es.ejemplo1;

import utils.Hibernate5Utils;

public class HibernateMain2 {

	public static void main(String[] args) {
		//Para este ejemplo deberiamos cambiar la configuracion de este fichero
		//a update despues de haber lanzado el HibernateMain1
		Hibernate5Utils.setFichero("es/ejemplo1/hibernate.cfg.xml");

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
