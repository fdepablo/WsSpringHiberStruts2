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
	<h1>Se ha registrado correctamente!!</h1>
	<!-- Podemos acceder a un objeto directamente mandandolo desde el action
		y luego poniendo el nombre del atributo (que invocara su "get")
	 -->
	<h3>Id: <s:property value="coche.id" /></h3>
	<h3>Marca: <s:property value="coche.marca" /></h3>
	<h3>Modelo: <s:property value="coche.modelo" /></h3>
</body>
</html>