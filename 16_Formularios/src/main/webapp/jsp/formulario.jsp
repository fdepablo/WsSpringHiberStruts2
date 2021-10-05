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
	<s:form action="procesarFormulario">
	    <s:textfield name="nombre" label="Nombre" />
	    <s:textfield name="username" label="Username" />
	    <s:password name="password" label="Password" />
	    <s:textfield name="edad" label="Edad" />
	    <!-- Cargamos la lista mediante el lenguaje OGNL, que usa un contexto estándar 
	    	de nombres para evaluar las expresiones -->
	    <s:radio label="genero" name="genero" list="#{'H':'Hombre','M':'Mujer'}"/>
	    <!-- Tambien podemos cargar la lista con valores mandados desde el action -->
	    <s:radio label="lenguaje" name="lenguaje" list="listaLenguajes" />
	    <s:checkboxlist label="¿Cuales son sus hobbies?" list="listaHobbies" 
			name="hobbies"/>
	    <s:checkbox name="compartir" fieldValue="true" label="¿Desea compartir los datos?"/>
	    <s:submit value="Enviar" />
	</s:form>
</body>
</html>