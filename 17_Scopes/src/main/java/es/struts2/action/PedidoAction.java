package es.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import es.struts2.modelo.entidad.Usuario;

@Namespace(value = "/")
@Action(value = "consultaPedido", 
		results = { 
				@Result(name = "success", location = "/jsp/paginaPrincipal.jsp"),
				@Result(name = "login", location = "/jsp/login.jsp")
				})
public class PedidoAction 
			extends ActionSupport 
			implements RequestAware, SessionAware{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private Map<String, Object> request;

	public String execute() {
		Usuario usuario = (Usuario)session.get("usuario");
		if(usuario != null) {
			System.out.println("El usuario que ha hecho la peticion de sus pedidos es " + 
					usuario.getNombre());
		
			String nombreUsuarioRequest = ((String)request.get("nombreUsuario"));
			System.out.println("Pero hemos perdido el usuario de la request :(" 
					+ nombreUsuarioRequest);
			
			List<String> listaPedidos = new ArrayList();
			listaPedidos.add("Impresora");
			listaPedidos.add("Silla");
			listaPedidos.add("Mesa");	
			
			request.put("listaPedidos", listaPedidos);
			
			return SUCCESS;
		}
		
		return LOGIN;
		
	}

	//Estos  metodos nos inyectan cada uno de los objetos
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}
}
