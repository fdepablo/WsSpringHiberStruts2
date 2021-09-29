/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo5.muchosamuchos.anotaciones;


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
            Hibernate5Utils.setFichero("es/ejemplo5/muchosamuchos/anotaciones/hibernate.cfg.xml");
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Salvamos estudiantes");
            session.save(estudiante1);
            session.save(estudiante2);
            session.save(estudiante3);
            tx.commit();
            System.out.println("estudiantes salvados");
            session.close();
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            Estudiante estudiante = session.get(Estudiante.class, 1);
            System.out.println("Estudiante con id 1:");
            System.out.println(estudiante.getNombre());
            System.out.println("Asignaturas para el estudiante con id 1:");
            for(Asignatura a : estudiante.getListaAsignaturas()){
            	System.out.println(a.getNombre());
            }
            session.close();
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            Asignatura asignatura = session.get(Asignatura.class, 1);
            System.out.println("Asignatura con id 1:");
            System.out.println(asignatura.getNombre());
            System.out.println("Estudiantes para la asignatura con id 1:");
            for(Estudiante e : asignatura.getListaEstudiantes()){
            	System.out.println(e.getNombre());
            }
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Hibernate5Utils.shutdown();
    }
    
}
