package es.ejemplo2.unoauno.anotaciones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String domicilio;
    private String codigoPostal;
    
    @OneToOne
    private Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
    
	//Ojo aqui, hay que parar esto porque si no dar� un StackOverflowError
	//si pintamos la direccion con la persona directamente, el toString de la persona
	//pinta la direccion que volveria a llamar al toString de direccion
	//y as� hasta el infinito, por eso ponemos 
	//'persona.getNombre()
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", domicilio=" + domicilio
				+ ", codigoPostal=" + codigoPostal + ", persona= " + persona.getNombre() + "]";
	}
}
