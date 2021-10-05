package es.struts2.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import es.struts2.modelo.entidad.Usuario;

/*
 * Struts 2 proporciona un conjunto de interfaces llamadas interfaces que acaban en "Aware"
 *  las cuales permite que nuestros Actions reciban cierta información, al momento de inicializarlos. 
 *  La mayoría de estas interfaces proporcionan un Map con los pares nombre-valor de los atributos 
 *  de cada uno de los scopes. 
 *  Asi pues tendremos ApplicationiAware, SessionAware y RequestAware que tienen solo un metodo
 *  que tenemos que implementar
 *  
 *  Si queremos utilizar los parametros de entrada podemos cogerlos de la request o utilizar la interfaz
 *  ParameterAware
 *   */

@Namespace(value = "/")
@Action(value = "login", 
		results = { 
				@Result(name = "success", location = "/jsp/paginaPrincipal.jsp"),
				@Result(name = "input", location = "/jsp/login.jsp") 
		}
)
public class LoginAwareAction 
			extends ActionSupport 
			implements RequestAware, SessionAware, ApplicationAware {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String password;
	
	private Map<String, Object> session;
	private Map<String, Object> application;
	private Map<String, Object> request;

	public String execute() {

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		
		System.out.println(usuario);
		
		if ("bud".equalsIgnoreCase(usuario.getNombre()) &&
				"1234".equalsIgnoreCase(usuario.getPassword())) {

			// Podemos acceder directamente al contexto servlet.
			// Suele ser mejor y más elegante utilizar las interfaces Aware
			// pero esta manera sería utilizando los objetos que crea JavaEE
			//HttpServletRequest request = ServletActionContext.getRequest();
			//HttpSession sesion = request.getSession(true);
			// sesion.setAttribute("usuario", usuario);

			// Con ActionContex podemos acceder a un map que
			// contiene los atributos de la sesion y trabajar más comodamente
			//Map sessionActionContext = ActionContext.getContext().getSession();
			// sesion.put("usuario", usuario);
			
			session.put("usuario", usuario);
			request.put("nombreUsuario", usuario.getNombre());
			application.put("usuariosRegistrados",2);
			return SUCCESS;
		}

		//Mandamos el mensaje en la requeste en vez de en un atributo "mensaje"
		request.put("error", "El nombre de usuario y contraseña no coinciden");
		return INPUT;
	}

	//Estos  metodos nos inyectan cada uno de los objetos, son metodos "callback"
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
