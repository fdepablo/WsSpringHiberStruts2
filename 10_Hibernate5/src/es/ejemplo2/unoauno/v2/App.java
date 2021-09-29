package es.ejemplo2.unoauno.v2;

import org.hibernate.Transaction;

import es.ejemplo2.unoauno.Direccion;
import es.ejemplo2.unoauno.Persona;

import org.hibernate.Session;

import utils.Hibernate5Utils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Hibernate5Utils.setFichero("es/ejemplo2/unoauno/v2/hibernate.cfg.xml");
    	Persona p = new Persona();
    	p.setId(1);
    	p.setNombre("Ruben");
    	Direccion d = new Direccion();
    	d.setDomicilio("Mayor");
		// Establezco los valores bidireccionales para permitir buscar tanto con persona como por direcci�n
		// Si en direcci�n no establezco la persona, al mapear la foreign key, busca en la clase direccion en el campo persona e intenta sacar el id de un null
		// produciendo el error de IdentifierGeneratorException
		// Si no usaramos este foreign key (Hay otros m�todos de generaci�n de relaciones one-to-one, pero son mas complejas y en anotaciones son muy simples)
		// podr�amos permitir su inserci�n, pero la b�squeda de direcci�n no dar�a la persona al no estar enlazado.
    	p.setDireccion(d);
    	d.setPersona(p);
    	Session openSession = Hibernate5Utils.getSessionFactory().openSession();
    	Transaction tx = openSession.beginTransaction();
    	openSession.save(p);
    	
    	tx.commit();
    	openSession.close();
    	
    	openSession = Hibernate5Utils.getSessionFactory().openSession();
    	//openSession.save(d);
    	Persona pp = (Persona)openSession.get(Persona.class, 1);
    	System.out.println(pp.getDireccion().getDomicilio());
    	openSession.close();
    	
    }
}// ESTA PERFECTO. QUE NO TE OIGO, ES MI ORDENADOR...
// ME OYES?
