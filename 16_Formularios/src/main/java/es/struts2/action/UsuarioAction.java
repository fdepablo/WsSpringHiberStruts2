package es.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.struts2.modelo.entidad.Usuario;

public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	//Parametros que recogeremos
	private String nombre;
	private String username;
	private String password;
	private int edad;
	private String genero;
	private String lenguaje;
	private List<String> hobbies;//hobbies elegidos por el usuario
	private boolean compartir;
	
	//Atributos que mandaremos al JSP de formulario
	private List<String> listaLenguajes;
	private List<String> listaHobbies;//todos los hobbies
	
	//Atributo que mandaremos al JSP de resultado
	private Usuario usuario;

	//Recordar que por cada peticion HTTP se va a crear un nuevo objeto
	//de este action
	public UsuarioAction() {

	}
	
	/**
	 * Este metodo sirve para mandar la información que necesita la página
	 * formulario.jsp para cargar los radio button y los checkbox
	 * @return
	 */
	public String mostrarFormulario() {
		//Esto habria que traerlo de BBDD
		listaLenguajes = new ArrayList<String>();
		listaLenguajes.add("English");
		listaLenguajes.add("France");
		listaLenguajes.add("Chinese");
		listaLenguajes.add("German");
		
		listaHobbies = new ArrayList<String>();
		listaHobbies.add("Lectura");
		listaHobbies.add("Cine");
		listaHobbies.add("Videojuegos");
		listaHobbies.add("Deporte");
		return INPUT;
	}
	
	@Override
	public String execute() throws Exception {
		usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setUsername(username);
		usuario.setPassword(password);
		//notese como se convierte automaticamente la edad
		//de string a int
		usuario.setEdad(edad);
		usuario.setGenero(genero);
		usuario.setLenguaje(lenguaje);
		usuario.setListaHobbies(hobbies);
		usuario.setCompartir(compartir);
		
		//Ahora habria que mandarlo a la BBDD para persistirlo
		System.out.println(usuario);
		
		return SUCCESS;
	}

	//Metodos para leer del JSP
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
	}
		
	
	//Metodos para mandar al JSP
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<String> getListaLenguajes() {
		return listaLenguajes;
	}

	public List<String> getListaHobbies() {
		return listaHobbies;
	}
}