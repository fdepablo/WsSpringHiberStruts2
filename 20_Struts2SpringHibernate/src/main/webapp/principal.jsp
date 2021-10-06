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

	<h1>Formulario para dar de alta un empleado</h1>
	
	<s:form action="/altaModificarEmpleado">
	    <s:textfield name="nombre" label="Nombre"/>
	    <s:textfield name="edad" label="edad"/>
	     <s:textfield name="id" label="Id (para modificar):"/>
	    <s:submit value="Enviar" />
	</s:form>
	
	<hr/>
	<s:iterator value="listaEmpleados">
		<strong> <s:property value="id"/> - <s:property value="nombre"/> - <s:property value="edad"/></strong><br/>
	</s:iterator>
	<hr/>
	
	<s:form action="/buscarEmpleado">
	    <s:textfield name="id" label="Id a buscar"/>
	    <s:submit value="Enviar" />
	</s:form>
	
	<s:form action="/borrarEmpleado">
	    <s:textfield name="id" label="Id a Borrar"/>
	    <s:submit value="Enviar" />
	</s:form>
</body>
</html>