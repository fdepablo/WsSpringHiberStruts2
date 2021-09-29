package es.ejemplo1.anotaciones;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;

public class PersonaDaoHibernate implements PersonaDao{

	private Transaction tx;  
    
    private Session iniciarSession(){
        Session session = Hibernate5Utils.getSessionFactory();
        return session;
    }
    
    private void manejaExcepcion(HibernateException he,String mensaje) throws HibernateException { 
        tx.rollback(); 
        throw new HibernateException(mensaje, he); 
    } 
    
    @Override
    public Integer insertar(Persona persona) throws HibernateException { 
          
        //utilizando los autocloseables de java 1.7 nos ahorramos la
        //clausula finally para cerrar la session
        try(Session session = iniciarSession()){
            tx = session.beginTransaction();
            //Devuelve el id de la persona que se dio de alta
            int i = (Integer) session.save(persona);
            tx.commit();
            return i;
        }catch(HibernateException he){
            manejaExcepcion(he,"Error en insertar persona");
            throw he;
        }        
    }

    @Override
    public void borrar(Persona persona) throws HibernateException{        
    	try(Session session = iniciarSession()){
    		tx = session.beginTransaction();
    		//A diferencia de JPA, aqui no hace falta tener el objeto
    		//cacheado
            session.delete(persona);
            tx.commit();
        }catch(HibernateException he){
            manejaExcepcion(he,"Error en borrar persona");
            throw he;
        }
    }

    @Override
    public void actualizar(Persona persona) throws HibernateException{        
    	try(Session session = iniciarSession()){
    		tx = session.beginTransaction();
    		//Actualiza el objeto por id, si no existe error
        	session.update(persona);
            tx.commit();
        }catch(HibernateException he){
            manejaExcepcion(he,"Error en actualizar persona");
            throw he;
        }
    }

    @Override
    public Persona get(int i) throws HibernateException{
    	try(Session session = iniciarSession()){
            Persona persona = (Persona)session.get(Persona.class,i);
            return persona;
        }catch(HibernateException he){
            manejaExcepcion(he,"Error en get Persona");
            throw he;
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Persona> getLista() throws HibernateException{
        try(Session session = iniciarSession()){
        	List<Persona> listapersona = session.createQuery("from Persona").getResultList();
            return listapersona;
        }catch(HibernateException he){
            manejaExcepcion(he,"Error en listar persona");
            throw he;
        }
    }

}
