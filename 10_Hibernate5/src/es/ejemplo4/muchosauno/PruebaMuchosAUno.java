/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo4.muchosauno;

import org.hibernate.Session;

import utils.Hibernate5Utils;


public class PruebaMuchosAUno {
    
    public static void main(String[] args) {
    	Periodico periodico1 = new Periodico();
    	periodico1.setNombre("As");
    	
    	Periodico periodico2 = new Periodico();
    	periodico2.setNombre("Marca");
    	
    	Periodico periodico3 = new Periodico();
    	periodico3.setNombre("Expansion");
    	
    	Hibernate5Utils.setFichero("es/ejemplo4/muchosauno/hibernate.cfg.xml");
    	
        Session sesion = Hibernate5Utils.getSessionFactory().openSession();
        sesion.beginTransaction();
        System.out.println("Salvando periodicos");
        sesion.save(periodico1);
        sesion.save(periodico2);
        sesion.save(periodico3);
        sesion.getTransaction().commit();
        sesion.close();
        
        Lector lector1 = new Lector();
        lector1.setNombre("Matias");
        lector1.setPeriodicoFavorito(periodico1);
        
        Lector lector2 = new Lector();
        lector2.setNombre("Pepe");
        lector2.setPeriodicoFavorito(periodico2);
        
        Lector lector3 = new Lector();
        lector3.setNombre("Manuel");
        lector3.setPeriodicoFavorito(periodico3);
        
        Lector lector4 = new Lector();
        lector4.setNombre("Rita");
        lector4.setPeriodicoFavorito(periodico1);
        
        sesion = Hibernate5Utils.getSessionFactory().openSession();
        sesion.beginTransaction();
        System.out.println("Salvando lectores");
        sesion.save(lector1);
        sesion.save(lector2);
        sesion.save(lector3);
        sesion.save(lector4);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
