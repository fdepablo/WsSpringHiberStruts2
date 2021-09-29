package es.ejemplo3.unoamuchos;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;


public class PruebaUnoAMuchos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro libro1 = new Libro();
        libro1.setTitulo("El Se�or de los anillos");
        Libro libro2 = new Libro();
        libro2.setTitulo("El Hobbit");
        
        Autor autor1 = new Autor();
        autor1.setNombre("J.R.R Tolkien");
        autor1.addLibro(libro1);
        autor1.addLibro(libro2);
        
        Libro libro3 = new Libro();
        libro3.setTitulo("El Quijote");
        
        Autor autor2 = new Autor();
        autor2.setNombre("Cervantes");
        autor2.addLibro(libro3);
        
        Transaction tx = null;
        Session session = null;
        try {
            Hibernate5Utils.setFichero("es/ejemplo3/unoamuchos/hibernate.cfg.xml");
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            System.out.println("Salvando objetos");
            session.save(autor1);
            session.save(autor2);
            tx.commit();
            System.out.println("Objetos salvados");
            session.close();
            
            //Accedemos a un autor
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a Autor");
            Autor autor = (Autor)session.get(Autor.class, 1);
            System.out.println("Autor desde transaccionalidad: " + autor);
            session.close();
            
            //Accedemos al mismo autor desde fuera de la transaccionalidad
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a Autor");
            autor = (Autor)session.get(Autor.class, 1);
            session.close();
            
            try{
            	//Aqui saltar� una excepcion porque estamos intentando acceder a los libros
            	//del autor fuera de un entorno de transaccionalidad
            	System.out.println("Autor SIN transaccionalidad: " + autor);
            }catch(LazyInitializationException lie){
            	System.out.println("No podemos acceder al autor sin transaccionalidad");
            	System.out.println("Ponga el atributo lazy='false' o mantengase en un entorno de ");
            	System.out.println("transaccionalidad");
                session = Hibernate5Utils.getSessionFactory().openSession();
                tx = session.beginTransaction();
                autor = (Autor)session.get(Autor.class, autor.getId());
                System.out.println("Autor CON transaccionalidad de nuevo: " + autor);
                session.close();
            }
            
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Accediendo a libro");
            Libro libroAutor = (Libro)session.get(Libro.class, 3);
            System.out.println("Autor del libro: " + libroAutor);
            session.close();
            
            
            //Eliminamos un autor           
            session = Hibernate5Utils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            System.out.println("Borrando autor1");
            session.delete(autor1);
            tx.commit();
            System.out.println("Autor borrado");
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
