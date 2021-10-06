package es.struts2.modelo.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String pw;

	public Usuario() {
		super();
	}

	public Usuario(String login, String pw) {
		super();
		this.login = login;
		this.pw = pw;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", pw=" + pw + "]";
	}
}
