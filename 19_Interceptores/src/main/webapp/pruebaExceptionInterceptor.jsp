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

	<h2 align="center">
		<font color="lightGreen">
			Redirección automática a una pagina de error
		</font>
	</h2>
	
	<s:form action="errorAction" theme="simple">
	
		<p align="center">
			<s:submit value="Pulsa para que pete"/>
		</p>
				
	</s:form>	

</body>
</html>