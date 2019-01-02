<%@page import="br.com.loopback.entidade.Usuario"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuarios</title>
</head>
<body>

	<table border="1">
	
	<tr bgcolor="#CCCCCC">
		<th>ID</th><th>Nome</th><th>Login</th>
	</tr>
	

<%
	//Scriptlet - não usual
	ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("lista");
	
	for(Usuario u: lista){
%>

	<tr>
		<td><%out.print(u.getId());%></td>
		<td><%out.print(u.getNome()); %></td>
		<td><%out.print(u.getLogin()); %></td>
	</tr>

	
<% } %>
	
	
	</table>

</body>
</html>