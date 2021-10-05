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

	<h1>Por favor autentiquese!</h1>
	<s:form action="/login">
	    <s:textfield name="nombre" label="Nombre"/>
	    <s:textfield name="password" label="Password" />
	    <s:submit value="Enviar" />
	</s:form>
	<strong><s:property value="#request.error" /></strong> <br />
</body>
</html>