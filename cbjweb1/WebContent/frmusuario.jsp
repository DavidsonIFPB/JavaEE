<%@page import="javax.xml.ws.Response"%>
<%@page import="br.com.loopback.entidade.Usuario"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar usu&aacute;rio</title>
</head>
<body>
<%

Usuario usuario = (Usuario) request.getAttribute("usuario");
  
%>

	<form action="usucontroller.do" method="post">
		
		<label>ID:</label>
		<input type="text" readonly="readonly" value="<%out.print(usuario.getId());%>"name="txtid"/><br>
		
		<label>Nome:</label>
		<input type="text" value="<%out.print(usuario.getNome());%>" name="txtnome"/><br>
		
		<label>Login:</label>
		<input type="text" value="<%out.print(usuario.getLogin());%>" name="txtlogin"/><br>
		
		<label>Senha:</label>
		<input type="password" name="txtsenha" maxlength="6"/><br>
		
		<input type="submit" value="Salvar"/>
		
	
	</form>

</body>
</html>