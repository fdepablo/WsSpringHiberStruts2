package es.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

//Este objeto action se creara por cada peticion HTTP
//El scope es "request"

//Si damos de alta los objetos por el fichero de configuracion struts.xml
//no tenemos la obligación de poner el namespace, pero por anotaciones
//es obligatorio

//Debemos usar la anotacioin @Action para establecer los parametros
//de configuracion del Action
//Dentro del atributo value establecemos como vamos a mapear el action
//tambien debemos poner el atributo result para establecer los resutados.

@Namespace(value = "/")
@Action(value="saludoAction",
		results = {
			@Result(name="success", location="/principal.jsp"),
			@Result(name="error", location="/error.jsp")
		})
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
