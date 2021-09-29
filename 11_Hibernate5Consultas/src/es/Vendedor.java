package es;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendedores")
public class Vendedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToOne(mappedBy = "vendedor",cascade=CascadeType.ALL) 
    private Direccion direccion;
    @OneToMany(mappedBy="vendedor",cascade=CascadeType.ALL) 
    private List<Cliente> listaClientes = new ArrayList<>();
    private Date fechaAlta;
    private Double salario;

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }    
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        direccion.setVendedor(this);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void addCliente(Cliente cliente){
        this.listaClientes.add(cliente);
        cliente.setVendedor(this);
    }

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + ", direccion="
				+ direccion + ", listaClientes=" + listaClientes
				+ ", fechaAlta=" + fechaAlta + ", salario=" + salario + "]";
	}

    
}
