package es.struts2.interceptores;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import es.struts2.modelo.entidad.Usuario;

//Esta clase es manejada por el contexto de Struts2
//Debemos de entender que struts nos dice que tenemos que configurar y programar
//este objeto como si fuera un objeto sin estado, ya que es posible que se cree
//el objeto varias veces durante la ejecucion del programa, es decir, configurarlo
//como los actions
public class InterceptorSeguridad implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Creando Interceptor de seguridad");
	}

	//El objetivo de este interceptor es controlar que el usuario se
	//ha logueado en nuestra pagina de login, lo vamos a usar para
	//securizar nuestras paginas comprometidas. 
	//En el Action de login vamos a crear un atributo "usuario"
	//y lo vamos a meter dentro del contexto de session
	//Si el usuario se ha logueado, le dejaremmos continuar a donde vaya
	//en caso contrario le mandaremos a la pagina de login
	
	//A este metodo se le pasa un objeto de tipo ActionInvocation, que podemos
	//sacar informacion sobre los parametros, los atributos de sesion, etc
	public String intercept(ActionInvocation aIn) throws Exception {
		
		System.out.println("=======================================");
		System.out.println("INTERCEPTOR_LOGIN: " + this);
		
		//Cuando registramos un usuario en nuestra app, metemos en su session un objeto
		//de tipo Usuario
		Map<String,Object> sesion = aIn.getInvocationContext().getSession();
		Usuario usr = (Usuario) sesion.get("usuario");
	
		//En caso de que no se haya logueado el usuario, le redireccinaremos
		//a la pagina de login. En caso contrario, seguiremos con la petición HTTP
		if(usr == null){
			return Action.LOGIN;
		} else {
			return aIn.invoke();//dejamos pasar al siguiente interceptor o al action
		}		
		//Aqui iria el codigo que queremos ejecutar cuando vuelva del action
	}

	public void destroy() {

	}
	
}









