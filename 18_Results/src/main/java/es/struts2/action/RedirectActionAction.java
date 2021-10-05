package es.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectActionAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> request;
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute() -> RedirectToAction");
		request.put("mensaje", "Saludos desde el redirectActionAction");
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}
	
	public String getNombreDelAction() {
		return "Lisa Simpson";
	}
	

}
