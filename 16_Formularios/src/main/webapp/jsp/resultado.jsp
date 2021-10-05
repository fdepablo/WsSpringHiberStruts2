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
	Nombre: <strong><s:property value="usuario.nombre" /></strong> <br />
	Username: <strong><s:property value="usuario.username" /></strong> <br />
	Password: <strong><s:property value="usuario.password" /></strong> <br />
	Edad: <strong><s:property value="usuario.edad" /></strong> <br />
	<!-- Mediante OGNL podemos hacer condicionales -->
	<s:if test="usuario.genero != null">
		Genero: <strong><s:property value="usuario.genero" /></strong> <br />
	</s:if>
	<s:if test="usuario.lenguaje != null">
		Lenguaje: <strong><s:property value="usuario.lenguaje" /></strong> <br />
	</s:if>
	<strong><s:property value="usuario.listaHobbies" /></strong> <br />
	<!-- Tambien podemos iterar una lista -->
	<h3>Lista iterada</h3>
	<s:iterator value="usuario.listaHobbies">
		<strong><s:property /></strong><br/>
	</s:iterator>
	¿Compartir datos?: <strong><s:property value="usuario.compartir" /></strong> <br />
</body>
</html>