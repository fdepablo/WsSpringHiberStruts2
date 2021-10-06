package es.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import es.struts2.modelo.entidad.Usuario;

//Notese que este login no extiende la la clase ActionSupport
public class LoginAction implements SessionAware {

	private Map<String, Object> sesion;
	
	//Cargamos el usuario mediante el interceptor "modelDriven", para que se 
	//genere el objeto usuario y se cargen los parametros directamente
	//Tiene que tener su "set" como cualquier atributo para que lo pueda
	//mapear
	//Si el usuario tuviera objetos complejos dentro, podriamos utilziar
	//los llamados conversores en struts2, pero de una manera sencilla
	//struts mapeara automaticamente los campos del formulario
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String execute(){
		String result = null;
		System.out.println("LoginAction -> Usuario: " + usuario);
		//La siguiente validacion debería hacerla un metodo de negocio
		if(usuario.getLogin().equals("bud") && usuario.getPw().equals("spencer")){
			result = "success";
			sesion.put("usuario", usuario);
		} else {
			result = "usrNoExiste";
			//Para vaciar el formulario nos basta con hacerle un new al usuario
			usuario = new Usuario();
		}
		
		return result;
	}

	@Override
	public void setSession(Map<String, Object> sesion) {
		this.sesion = sesion;
		
	}
	
	
	
}

































