package es.ejemplo3.unoamuchos.anotaciones;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;


public class PruebaUnoAMuchos {

    public static void main(String[] args) {
        Libro libro1 = new Libro();
        libro1.setTitulo("El Se�or de los anillos");
        Libro libro2 = new Libro();
        libro2.setTitulo("El Hobbit");
        
        Autor autor1 = new Autor();
        autor1.setNombre("J.R.R Tolkien");
        autor1.addLibro(libro1);//Ojo!Mirad este metodo, hace bidireccion
        autor1.addLibro(libro2);
        
        Libro libro3 = new Libro();
        libro3.setTitulo("El Quijote");
        
        Autor autor2 = new Autor();
        autor2.setNombre("Cervantes");
        autor2.addLibro(libro3);
        
        Transaction tx = null;
        Session session = null;
        try {
            Hibernate5Utils.setFichero("es/ejemplo3/unoamuchos/anotaciones/hibernate.cfg.xml");
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            System.out.println("Salvando autores");
            session.save(autor1);
            session.save(autor2);
            tx.commit();
            System.out.println("Autores salvados");
            session.close();
            
            //Accedemos a un autor
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a Autor");
            Autor autor = session.get(Autor.class, 1);
            System.out.println("Autor desde contexto de transaccionalidad: " + autor);
            session.close();
            
            //Accedemos al mismo autor desde fuera de la transaccionalidad
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a Autor");
            autor = session.get(Autor.class, 1);
            session.close();
            
            try{
            	//Aqui saltar� una excepcion porque estamos intentando acceder a 
            	//los libros del autor (ya que invocamos al toString())
            	//fuera de un entorno de transaccionalidad (hemos hecho el 'session.close()')
            	System.out.println("Autor SIN transaccionalidad: " + autor);
            }catch(LazyInitializationException lie){
            	System.out.println("No podemos acceder al autor sin transaccionalidad");
            	System.out.println("Ponga el elemento 'fetch=FetchType.EAGER' o mantengase en un entorno de ");
            	System.out.println("transaccionalidad");
                session = Hibernate5Utils.getSessionFactory().openSession();
                tx = session.beginTransaction();
                autor = session.get(Autor.class, autor.getId());
                System.out.println("Autor CON transaccionalidad de nuevo: " + autor);
                session.close();
            }
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a libro");
            libro3 = session.get(Libro.class, 3);
            System.out.println("Libro con id 3: " + libro3);
            System.out.println("Autor del libro con id 3: " + libro3.getAutor());
            session.close();
            
            
            //Eliminamos un autor           
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Borrando autor1");
            session.delete(autor1);
            //Si borramos un autor dependiendo del tipo de cascada tambien borraremos sus libros
            //ojo que podemos quedarnos sin base de datos :)
            tx.commit();
            System.out.println("Autor borrado y sus libros borrados");
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Hibernate5Utils.shutdown();
    }
    
}
