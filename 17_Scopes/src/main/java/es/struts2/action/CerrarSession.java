package es.struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
@Action(value = "cerrarSession", 
		results = {
				@Result(name = "input", location = "/jsp/login.jsp") })
public class CerrarSession extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String execute() {
		//Struts no nos proporciona una manera directa de cerrar una sesion
		//por lo que debemos recurrir a la request directamente
		HttpServletRequest request = ServletActionContext.getRequest();		
		System.out.println("Cerrando session con ID: " + request.getSession().getId());
		request.getSession().invalidate();
		return INPUT;
	}
}
