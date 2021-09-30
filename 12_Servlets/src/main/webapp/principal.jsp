<%@page import="es.curso.servlet.Coche"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		LOS JSPs SON SERVLETS, lo que pasa es que se compilan y se crea el objeto
		cuando se demanden.
		
		Este servlet no esta pensados para hacer de funcion de controlador, estan
		pensados para vista
	 -->
	 <h1>Ha entrado satisfactoriamente</h1>
	 
	 <!-- En JSP tenemos una tecnica para generar contenido dinamico, 
	 	  que son los scriptlets, que se abren en java con siguientes etiquetas
	 	  
	 	  No es recomendable esta menera, hay tecnicas
	  -->
	  
	  <%
	  	//Todo esto es codio java
	  	for(int i = 0; i <=10 ;i++){
	  %>
	  	<h2><%=i %></h2>
	  <%
	  	}
	  %>
	  
	  <%
	  	String usuario = request.getParameter("usuario");
	  	//String mensaje = (String)request.getAttribute("mensaje");
	  	//Coche coche = (Coche)request.getAttribute("coche");
	  %>
	  
	  <h2 style="color: red"><%=usuario %></h2>
	  <!-- Normalmente se usan expresion del lenguaje JSP para acceder
	  a los atributos de request o de session que estan en nuestro programa -->
	  <h2 style="color: blue">${mensaje}</h2>
	  <h2 style="color: green">${coche.id}</h2>
	  <h2 style="color: green">${coche.marca}</h2>
	  <h2 style="color: green">${coche.modelo}</h2>
	  
	  <a href="SegundoServlet">Pincha aqui para ir al segundo Servlet</a>
	  
	  <h2 style="color: blue">${mensajeSession}</h2>
	  <h2 style="color: blue">${mensajeAplicacion}</h2>
</body>
</html>