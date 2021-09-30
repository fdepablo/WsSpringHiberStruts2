package es.curso.filtro;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FiltroTiempo implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Todo el codigo puesto antes del metodo doFilter, se ejecutara al
		//mandar la requeste
		System.out.println(request.getParameter("usuario"));
		
		Date tInicial = new Date();
		
		//Con este metodo dejamos seguir a la peticion a su recurso final
		chain.doFilter(request, response);
		//Todo el codigo puesto depues del metodo doFilter, se ejecutara al
		//regreso de la peticion
		
		Date tFinal = new Date();
		
		System.out.println("Tiempo total: " + (tFinal.getTime() - tInicial.getTime()));
		
	}

}
