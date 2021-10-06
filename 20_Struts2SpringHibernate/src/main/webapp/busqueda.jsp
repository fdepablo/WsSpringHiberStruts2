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
	<h2 style="color:blue"><s:property value="empleado.id" /></h2>
	<h2 style="color:blue"><s:property value="empleado.nombre"/></h2>
	<h2 style="color:blue"><s:property value="empleado.edad"/></h2>
</body>
</html>