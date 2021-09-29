package es.ejemplo6.tienda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos_productos")
public class PedidoProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Producto producto;
	
	private double subtotal;
	private int cantidad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void calcularSubtotal() {
		this.subtotal = cantidad * producto.getPrecio(); 
	}
	
	@Override
	public String toString() {
		return "PedidoProducto [id=" + id + ", pedidoId="+ pedido.getId() + ", productoId=" + producto.getId() + ", subtotal=" + subtotal
				+ ", cantidad=" + cantidad + "]";
	}
	
	
}
