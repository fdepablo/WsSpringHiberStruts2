package es;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String calle;
    private String codigoPostal;
    @OneToOne
    @JoinColumn(name = "fk_id_vendedor", referencedColumnName = "id")
    private Vendedor vendedor;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", codigoPostal=" + codigoPostal + '}';
    }
}
