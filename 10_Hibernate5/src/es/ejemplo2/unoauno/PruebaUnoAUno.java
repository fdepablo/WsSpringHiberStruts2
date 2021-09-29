/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo2.unoauno;


import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;


public class PruebaUnoAUno {


    public static void main(String[] args) {
        Direccion direccion1 = new Direccion();
        direccion1.setDomicilio("Avenida de Burgos 2");
        direccion1.setCodigoPostal("28990");
        
        Direccion direccion2 = new Direccion();
        direccion2.setDomicilio("Avenida del ensanche de vallecas 45");
        direccion2.setCodigoPostal("20051");
        
        Persona persona1 = new Persona();
        persona1.setNombre("Pedro el cruel");
        persona1.setDireccion(direccion1);
        
        Persona persona2 = new Persona();
        persona2.setNombre("Arturo");
        persona2.setDireccion(direccion2);
        
        
        Transaction tx = null;
        Session session = null;
        try {
        	Hibernate5Utils.setFichero("es/ejemplo2/unoauno/hibernate.cfg.xml");
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            System.out.println("Salvando objetos");
            session.save(persona1);
            session.save(persona2);
            
            System.out.println("Commit objetos");
            tx.commit();
            
            System.out.println("Obtenemos objetos de id 1: ");
            persona1 = (Persona) session.get(Persona.class,1);
            System.out.println(persona1);
            
            Direccion direccion3 = (Direccion) session.get(Direccion.class,1);
            System.out.println(direccion3);
            session.close();
            
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Borramos la primera persona");
            session.delete(persona1);
            tx.commit();
            
            session.close();
			
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
            
    }
    
}
