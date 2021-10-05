package es.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Chain1Action extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> request;
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute() -> Chain1Action");
		request.put("mensaje", "Hola chain1 ");
		return SUCCESS;//google
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}
}