<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Pruebas interceptor 'InterceptorLogin'</h1>
	
	<s:form action="login">
		<!-- Podemos usar el interceptor modelDriven para mapear crear automaticamente
		valores de un formulario a un objeto java del action -->
		<s:textfield label="Login" name="usuario.login"/>
		<s:textfield label="Pw"    name="usuario.pw"/>
		<s:submit value="Entrar"/>

	</s:form>

</body>
</html>