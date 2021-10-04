package es.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

//Este objeto action se creara por cada peticion HTTP
//El scope es "request"
public class SaludoAction extends ActionSupport{

	private static final long serialVersionUID = 11111111111L;

	//En un action podemos recoger parametros que nos envien las paginas
	//declarando atributos con el mismo nombre
	//Mediante interceptores, se mapearan a dichos atributos y se convertiran
	//los tipos.
	private String nombre;
	private int numero;
	private String mensaje;
	
	//Este es el metodo por defecto que se ejecutara
	@Override
	public String execute() throws Exception {
		
		System.out.println("Nombre recibido: " + nombre);
		System.out.println("Numero recibido: " + numero);
		
		if("bud".equalsIgnoreCase(nombre)) {
			mensaje = "Bienvenido " + nombre + " ha elegido el numero " + numero;
			return SUCCESS;
		}
		
		mensaje = "No tienes permisos para entrar en la pagina :(";
		return ERROR;
	}

	//El mapeo de los atributos se hara en funcion de los getter y setter 
	//que declaremos.
	
	//Si queremos recibir un parametro de la pagina web, el atributo tiene
	//que tener declarado su "set"
	//Si queremos enviar un valor a la pagina web, el atributo tiene que
	//tener su "get"
	//Siempre hay que ponerse desde el punto de vista del "jsp"
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}
