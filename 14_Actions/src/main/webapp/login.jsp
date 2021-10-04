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
	<h1>Por favor registrese!!</h1>
	<s:form action="loginAction">
		<s:textfield name="nombre"></s:textfield>
		<s:textfield name="pw"></s:textfield>
		<s:submit value="Pulse para enviar"></s:submit>
	</s:form>
	
	<!-- Si la propiedad no se encuentra, no pinta nada -->
	<h1 style="color:red"><s:property value="nombre" /><s:property value="mensaje" /></h1>
</body>
</html>