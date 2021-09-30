package es.curso.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Dentro de la anotacion ponemos el path de la URL con el que queremos mapear
//este objeto SERVLET
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Entraremos por aqui si la petion HTTP se ha hecho con el verbo GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Los parametros siempre los recibimos en String
		String nombre = request.getParameter("usuario");
		//En contexto servidor ser vera por consola lo que escribis
		System.out.println("Parametro recibido: " + nombre);
		
		String mensaje = "Se ha logado satisfactoriamente";
		Coche coche = new Coche();
		coche.setId(1);
		coche.setMarca("Ferrari");
		coche.setModelo("Testarrosa");
		//Decidimos mostrar la vista principal.jsp
		RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("coche", coche);
		request.getSession().setAttribute("mensajeSession", "Esto es un mensaje de session");
		request.getServletContext().setAttribute("mensajeAplicacion", "Este es un mensaje de aplicacion");
		rd.forward(request, response);		
	}

	//Entraremos por aqui si la petion HTTP se ha hecho con el verbo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<title>");
	}
	
}
