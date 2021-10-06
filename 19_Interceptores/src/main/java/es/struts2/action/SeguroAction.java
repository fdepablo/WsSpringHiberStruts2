package es.struts2.action;


public class SeguroAction {

	private double dinero;
	
	public String execute(){
		System.out.println("SeguroAction -> Procesando peticion ");
		dinero = 500;
		return "success";
	}

	public double getDinero() {
		return dinero;
	}


}
