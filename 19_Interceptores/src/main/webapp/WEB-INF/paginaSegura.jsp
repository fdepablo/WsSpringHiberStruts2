<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
	<!-- Podemos poner nuestras paginas seguras dentro de WEB-INF, ya que esta carpeta es inaccesible
	desde fuera del servidor. Solo podemos cargarlas si hacemos un dispatcher desde un action
	Lo unico que nos quedaría es securizar dicho action.
	 -->
	<h1>Esta Pagina es segura!!!</h1>
	<h2>Bienvenido <strong><s:property value="#session.usuario.login" /></strong> <br /></h2>	
	
	<s:a action="seguroAction">Mostrar Dinero de la Cuenta</s:a><br />
	<hr/>
	Dinero: <strong><s:property value="dinero" /></strong> 
</body>
</html>