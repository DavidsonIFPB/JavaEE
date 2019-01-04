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
		<th>ID</th><th>Nome</th><th>Login</th><th>Excluir</th>
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
		<td><a onclick="myFunction()" href="usucontroller.do?acao=exc&id=<%out.print(u.getId());%>">Excluir</a>
		|
		<a href="usucontroller.do?acao=alt&id=<%out.print(u.getId());%>">Alterar</a>
		</td>
	</tr>

	
<% } %>
	<script>
		function myFunction() {
		  var txt;
		  var r = confirm("Deseja Excluir?");
		  if (r == true) {
		    txt = "You pressed OK!";
		  } else {
		    txt = "You pressed Cancel!";
		  }
		  window.location.href="http://127.0.0.1:8080/cbjweb1/usucontroller.do";
		}
		 
	</script>
	
	</table>

</body>
</html>