/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo6.tienda;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Hibernate5Utils;

public class MainTienda {

	public static void main(String[] args) {

		
		Producto producto1 = new Producto();
		producto1.setNombre("Lapices");
		producto1.setPrecio(0.20);
		producto1.setStock(100);
		
		Producto producto2 = new Producto();
		producto2.setNombre("Boligrafos");
		producto2.setPrecio(0.50);
		producto2.setStock(200);
		
		Pedido pedido1 = new Pedido();
		pedido1.setCodigo("GHTY54");
		pedido1.setImporte(250);
		
		Pedido pedido2 = new Pedido();
		pedido2.setCodigo("KLO98");
		pedido2.setImporte(350);

		//En el pedido 1 se pidieron los productos 1 y 2
		PedidoProducto pp11 = new PedidoProducto();
		pp11.setCantidad(23);
		pp11.setSubtotal(100);
		pp11.setPedido(pedido1);
		pp11.setProducto(producto1);
		
		PedidoProducto pp12 = new PedidoProducto();
		pp12.setCantidad(10);
		pp12.setSubtotal(50);
		pp12.setPedido(pedido1);
		pp12.setProducto(producto2);
		
		//En el pedido 2 se pidieron solamente el producto 2
		PedidoProducto pp21 = new PedidoProducto();
		pp21.setCantidad(50);
		pp21.setSubtotal(250);
		pp21.setPedido(pedido2);
		pp21.setProducto(producto2);

		Transaction tx = null;
		Session session = null;
		try {
			Hibernate5Utils.setFichero("es/ejemplo6/tienda/hibernate.cfg.xml");

			//Para salvar todo
			session = Hibernate5Utils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Para no poner este deberiamos de a los productos meterle el PedidoProducto
			session.save(producto1);
			session.save(producto2);
			//Como ya hemos puesto relacion entre  Pedido y PedidoProducto no hace falta
			//session.save(pedido1);
			//session.save(pedido2);
			session.save(pp11);
			session.save(pp12);
			session.save(pp21);
			
			tx.commit();
			session.close();
			
			//Suponemos que existen unos productos preestablecidos y creamos un nuevo pedido
			session = Hibernate5Utils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Producto producto3 = new Producto();
			producto3.setNombre("Cuadernos");
			producto3.setPrecio(1.50);
			producto3.setStock(20);
			
			Producto producto4 = new Producto();
			producto4.setNombre("Sacapuntas");
			producto4.setPrecio(0.75);
			producto4.setStock(40);
			
			session.save(producto3);
			session.save(producto4);
			
			tx.commit();
			session.close();
			
			//Ahora creamos los pedidos
			session = Hibernate5Utils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Pedido pedido3 = new Pedido();
			pedido3.setCodigo("R2D2");
			
			PedidoProducto pp31 = new PedidoProducto();
			pp31.setProducto(session.get(Producto.class, 3));
			pp31.setCantidad(10);
			pp31.calcularSubtotal();
			
			pedido3.addPedidoProducto(pp31);
			
			PedidoProducto pp32 = new PedidoProducto();
			pp32.setProducto(session.get(Producto.class, 4));
			pp32.setCantidad(15);
			pp32.calcularSubtotal();
			
			pedido3.addPedidoProducto(pp32);
			pedido3.calcularImporte();
			
			session.save(pedido3);
			
			tx.commit();
			session.close();
			
			//Para acceder
			session = Hibernate5Utils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Pedido pedido = session.get(Pedido.class, 1);
			System.out.println(pedido);
			
			Producto producto = session.get(Producto.class, 1);
			System.out.println(producto);			
			
			tx.commit();
			session.close();

			//Para borrar
			session = Hibernate5Utils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			PedidoProducto pp = new PedidoProducto();
			pp.setId(1);
			session.delete(pp);
			
			//Esto solo borra el pedido, no los PedidoProducto
			Pedido p1 = new Pedido();
			p1.setId(1);
			session.delete(p1);
			
			//Para borrar los pedido con sus PedidosProducto debemos de tener
			//los objetos referenciados desde el pedido
			Pedido p2 = session.get(Pedido.class, 1);
			session.delete(p2);
			
			tx.commit();
			session.close();

			/* TODO
			session = Hibernate5Utils.getSessionFactory().openSession();
			// this user is obtained from the database with ID 34
			User user = (User) session.get(User.class, new Long(34));
			 
			// this group is obtained from the database with ID 17
			Group group = (Group) session.get(Group.class, new Long(17));
			 
			UserGroup userGroup = new UserGroup();
			userGroup.setGroup(group);
			userGroup.setUser(user);
			userGroup.setActivated(true);
			userGroup.setRegisteredDate(new Date());
			 
session.save(userGroup);
			session.close();
			*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Hibernate5Utils.shutdown();
	}

}
