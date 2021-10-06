package es.struts2.action;

public class ErrorAction {

	public String execute() throws Exception{		
		//Esto lanza una excepci�n que capturar� el ExceptionInterceptor
		//para redirigir a un jsp que hemos definido en struts.xml
		//As� evitamos las p�ginas con 500 Internal server error
		int numero;
		try {
			numero = 50/0;
			System.out.println(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		
		
		return "success";
	}
	
}
