/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo5.muchosamuchos;


import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;


public class PruebaMuchosAMuchos {

    public static void main(String[] args) {
        Asignatura asignatura1 = new Asignatura();
        asignatura1.setNombre("Matematicas");
        
        Asignatura asignatura2 = new Asignatura();
        asignatura2.setNombre("Derecho");
        
        Asignatura asignatura3 = new Asignatura();
        asignatura3.setNombre("Historia");
        
        Asignatura asignatura4 = new Asignatura();
        asignatura4.setNombre("Biologia");
        
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Antonio");
        
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Pedro");
        
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Juan");
        
        estudiante1.addAsignatura(asignatura1);
        estudiante1.addAsignatura(asignatura2);
        estudiante1.addAsignatura(asignatura3);
        
        estudiante2.addAsignatura(asignatura3);
        estudiante2.addAsignatura(asignatura4);
        
        estudiante3.addAsignatura(asignatura1);
        estudiante3.addAsignatura(asignatura4);
        
        Transaction tx = null;
        Session session = null;
        try {
            Hibernate5Utils.setFichero("es/ejemplo5/muchosamuchos/hibernate.cfg.xml");
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Salvamos estudiantes");
            session.save(estudiante1);
            session.save(estudiante2);
            session.save(estudiante3);
            tx.commit();
            System.out.println("estudiantes salvados");
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
