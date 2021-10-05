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
	<h1>Bienvenidos!</h1>
	Mensaje: <strong><s:property value="#request.mensaje" /></strong> <br />
	Parametro Nombre: <strong><s:property value="nombre" /></strong> <br />
	<hr/>
	<s:a action="redirect-action">RedirectActionAction</s:a>
	<s:a action="chain1">ChainAction</s:a><br />
</body>
</html>