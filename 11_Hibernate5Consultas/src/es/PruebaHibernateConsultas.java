package es;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import utils.Hibernate5Utils;

public class PruebaHibernateConsultas {

	private static Session session;
	private static Transaction tx;
	public static final String FICHERO = "es/hibernate.cfg.xml";

	public static void main(String[] args) {
		try {
			Hibernate5Utils.setFichero(FICHERO);
			cargarDatos();
			consultasJPQL();
		} catch (Exception ex) {
			Logger.getLogger(PruebaHibernateConsultas.class.getName()).log(
					Level.SEVERE, null, ex);
		}finally {
			Hibernate5Utils.shutdown();
		}
	}

	private static void abrirSesion(String frase) {
		System.out.println("***************** " + frase +" ***************************");
		session = Hibernate5Utils.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private static void cerrarSesion(String frase) {
		tx.commit();
		session.close();
		System.out.println("**************FIN " + frase +" ***************************");
	}
	
	public static boolean cargarDatos() {
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("Alcala 108");
		direccion1.setCodigoPostal("28034");

		Direccion direccion2 = new Direccion();
		direccion2.setCalle("Gran Via 34");
		direccion2.setCodigoPostal("28344");

		Direccion direccion3 = new Direccion();
		direccion3.setCalle("Labranza 23");
		direccion3.setCodigoPostal("28322");

		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Ramon Garcia");
		cliente1.setTelefono(5559765);

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Pedro J Ramirez");
		cliente2.setTelefono(6664545);

		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Raul Gonzalez");
		cliente3.setTelefono(5674321);

		Cliente cliente4 = new Cliente();
		cliente4.setNombre("Pepe Reina");
		cliente4.setTelefono(8765432);

		Cliente cliente5 = new Cliente();
		cliente5.setNombre("Sergio Ramos");
		cliente5.setTelefono(2147485);

		Vendedor vendedor1 = new Vendedor();
		vendedor1.setNombre("Felix de Pablo");
		vendedor1.setSalario(50000.00);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.set(2010, Calendar.FEBRUARY, 20);
		vendedor1.setFechaAlta(calendar1.getTime());
		vendedor1.setDireccion(direccion1);
		vendedor1.addCliente(cliente1);
		vendedor1.addCliente(cliente2);

		Vendedor vendedor2 = new Vendedor();
		vendedor2.setNombre("Angel Poza");
		vendedor2.setSalario(45000.00);
		Calendar calendar2 = new GregorianCalendar();
		// calendar2.set(2012, Calendar.JULY, 10);
		calendar2.set(2010, Calendar.FEBRUARY, 20);
		vendedor2.setFechaAlta(calendar2.getTime());
		vendedor2.setDireccion(direccion2);
		vendedor2.addCliente(cliente3);
		vendedor2.addCliente(cliente4);

		Vendedor vendedor3 = new Vendedor();
		vendedor3.setNombre("Javier Bardem");
		vendedor3.setSalario(55000.00);
		Calendar calendar3 = new GregorianCalendar();
		calendar3.set(2008, Calendar.NOVEMBER, 1);
		vendedor3.setFechaAlta(calendar3.getTime());
		vendedor3.setDireccion(direccion3);
		vendedor3.addCliente(cliente5);

		abrirSesion("Salvando objetos");

		session.save(vendedor1);
		session.save(vendedor2);
		session.save(vendedor3);

		cerrarSesion("Salvando objetos");

		System.out.println("**********************************************");

		return true;
	}

	public static void consultasJPQL() {

		abrirSesion("lista vendedores");

		// Query que muestra todos los vendedores
		TypedQuery<Vendedor> query = session.createQuery("FROM Vendedor v");
		// Se puede poner tambien Vendedor a secas
		List<Vendedor> listaVendedores = query.getResultList();
		for (Vendedor vendedor : listaVendedores) {
			System.out.println(vendedor);
		}

		cerrarSesion("lista vendedores");

		// INNER JOIN
		// Con esta query buscamos sacar que clientes tiene cada vendedor asociados
		// Ej salida:
		// Felix de Pablo Ramon Garcia
		// Felix de Pablo Pedro J Ramirez
		// Angel Poza Raul Gonzalez
		// Angel Poza Pepe Reina
		// Javier Bardem Sergio Ramos
		abrirSesion("inner join vendedor-cliente");

		TypedQuery<?> query2 = session
				.createQuery("SELECT v.nombre, c.nombre FROM Vendedor v inner join v.listaClientes c");
		List<Object[]> lista = (List<Object[]>) query2.getResultList();
		for (Object[] ol : lista) {
			System.out.println("vendedor: " + ol[0] + " cliente: " + ol[1]);
		}

		cerrarSesion("inner join vendedor-cliente");

		// Mismo ejemplo que el anterior, pero esta vez creamos un objeto con el
		// resultado
		abrirSesion("objeto vendedor-cliente");

		TypedQuery<VendedorCliente> query3 = session
				.createQuery("SELECT "
						+ "new es.VendedorCliente(v.nombre, c.nombre) "
						+ "FROM Vendedor v inner join v.listaClientes c");
		List<VendedorCliente> listaVendedorCliente = query3.getResultList();
		for (VendedorCliente vc : listaVendedorCliente) {
			System.out.println(vc.getNombreVendedor() + " "
					+ vc.getNombreCliente());
		}

		cerrarSesion("objeto vendedor-cliente");

		// EJEMPLO CON WHERE
		abrirSesion("Where 1");

		TypedQuery<Vendedor> query4 = session
				.createQuery("FROM Vendedor v WHERE v.salario=55000");
		Vendedor vendedor1 = (Vendedor) query4.getSingleResult();
		System.out.println(vendedor1);
		cerrarSesion("Where 1");
		
		abrirSesion("Where 2");

		query4 = session
				.createQuery("FROM Vendedor v WHERE v.nombre LIKE '%Javi%'");
		vendedor1 = (Vendedor) query4.getSingleResult();
		System.out.println(vendedor1);
		cerrarSesion("Where 2");
		
		abrirSesion("Where 3");

		query4 = session
				.createQuery("FROM Vendedor v WHERE v.direccion.codigoPostal='28344'");
		vendedor1 = (Vendedor) query4.getSingleResult();
		System.out.println(vendedor1);
		cerrarSesion("Where 3");

		// EJEMPLO CON PARAMETROS
		// Mejor manera para evitar la inyeccion de dependencias
		abrirSesion("Parametros");
		// Son los ":" lo que marcan el parametro que va a guardar el valor
		TypedQuery<Vendedor> query5 = session
				.createQuery("FROM Vendedor v WHERE v.direccion.codigoPostal = :cp");
		query5.setParameter("cp", "28344");
		vendedor1 = (Vendedor) query5.getSingleResult();
		System.out.println(vendedor1);
		cerrarSesion("Parametros");

		// FUNCIONES DE AGREGACION
		abrirSesion("Contador");
		TypedQuery<Long> query6 = session.createQuery("SELECT COUNT(*) FROM Vendedor");
		Long contador = query6.getSingleResult();
		System.out.println("El numero de vendedores es: " + contador);
		cerrarSesion("Contador");

		//Ejemplo con GROUP BY
		//GROUP BY statement es a menudo usado con funciones de agregacion
		//(COUNT, MAX, MIN, SUM, AVG) para agrupar el conjunto de resultados 
		//en una o mas columnas
		abrirSesion("Group by");
		
		//En esta query buscamos que Sume todos los salarios agrupados por fecha 
		//de alta. En este caso Felix y Angel se dieron de alta el mismo día
		//calendar1.set(2010, Calendar.FEBRUARY, 20);
		//por lo que la suma de felix y angel es 95000
		//y la de Javier Bardem es de 55000 		
		TypedQuery<Double> query7 = session
				.createQuery("SELECT SUM(v.salario) FROM Vendedor v GROUP BY v.fechaAlta");
		List<Double> listaSalarios = query7.getResultList();
		for (Double d : listaSalarios) {
			System.out.println("Salario: " + d);
		}

		cerrarSesion("Group by");

		// EJemplo de parametros como objetos
		abrirSesion("Parametros de objetos");
		TypedQuery<Vendedor> query8 = session.createQuery("FROM Vendedor v WHERE v = :vaux");
		Vendedor vendedorAux = new Vendedor();
		vendedorAux.setId(1);
		query8.setParameter("vaux", vendedorAux);
		vendedor1 = query8.getSingleResult();
		System.out.println(vendedor1);
		cerrarSesion("Parametros de objetos");
	}
	
}
