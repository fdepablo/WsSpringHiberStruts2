package es.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import es.struts2.modelo.entidad.Coche;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String pw;
	private Coche coche;
	private String mensaje;
	
	@Override
	public String execute() throws Exception {
		System.out.println("LoginAction -> execute()");
		if("bud".equalsIgnoreCase(nombre) && "123456".equalsIgnoreCase(pw)) {
			//simulamos un acceso a datos
			coche = new Coche();
			coche.setId(1);
			coche.setMarca("Ferrari");
			coche.setModelo("Testarrosa");
			return SUCCESS;
		}
		
		mensaje = "Usuario o contraseña mal introducidos";
		return LOGIN;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Coche getCoche() {
		return coche;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}
