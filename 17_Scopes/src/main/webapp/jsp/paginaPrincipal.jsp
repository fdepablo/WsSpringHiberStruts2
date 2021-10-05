<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Nombre de la session: <strong><s:property value="#session.usuario.nombre" /></strong> <br />
	Nombre de la request: <strong><s:property value="#request.nombreUsuario" /></strong> <br />
	Usuarios registrados: <strong><s:property value="#application.usuariosRegistrados" /></strong> <br />

	<!-- Generar la url correspondiente a un action, nos pone el codigo para acceder
	sin preocuparnos -->
	<a href="<s:url action="consultaPedido"/>">Ir a pedidos</a>
	
	<hr/>
	<s:iterator value="#request.listaPedidos">
		<strong><s:property/></strong><br/>
	</s:iterator>
	<hr/>
	<a href="<s:url action="cerrarSession"/>">CERRAR SESSION</a>
</body>
</html>