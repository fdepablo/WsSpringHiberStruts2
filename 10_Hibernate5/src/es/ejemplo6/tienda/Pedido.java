package es.ejemplo6.tienda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private double importe;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pedido")
    private List<PedidoProducto> listaPedidosProducto = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public List<PedidoProducto> getListaPedidosProducto() {
		return listaPedidosProducto;
	}
	public void setListaPedidosProducto(List<PedidoProducto> listaPedidosProducto) {
		this.listaPedidosProducto = listaPedidosProducto;
	}
	
	public void addPedidoProducto(PedidoProducto pp) {
		this.listaPedidosProducto.add(pp);
		pp.setPedido(this);
	}
	
	public void calcularImporte(){
		double importe = 0;
		for(PedidoProducto pp : listaPedidosProducto) {
			importe+=pp.getSubtotal();
		}
		this.importe = importe;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", importe=" + importe + ", listaPedidosProducto="
				+ listaPedidosProducto + "]";
	}
	
	
}
