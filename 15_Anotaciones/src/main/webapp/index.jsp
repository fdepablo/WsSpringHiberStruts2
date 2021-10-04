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
	<h1>Bienvenidos a nuestra pagina!!</h1>
	<!-- Struts pone por defecto estilos a sus etiquetas basandose en 
		el atibuto "theme", que se establecen estilos y maneras de plasmar
		el HTML
	 -->
	<s:form action="saludoAction">
		<s:textfield name="nombre"></s:textfield>
		<s:textfield name="numero"></s:textfield>
		<s:submit value="Pulse para enviar"></s:submit>
	</s:form>
</body>
</html>