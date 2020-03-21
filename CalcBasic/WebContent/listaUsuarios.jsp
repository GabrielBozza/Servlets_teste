<%@page import="java.util.List"%>
<%@page import="br.com.exemplo.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
</body>
<%

//List<Usuario> lista = usuDAO.buscarTodos(usu);
List<Usuario> listaResultado = (List<Usuario>)request.getAttribute("lista");
%>
<table border="1">
 <tr bgcolor="#eaeaea">
 	<th>ID</th>
 	<th>Nome</th>
 	<th>Idade</th>
 	<th>Email</th>
 	<th>Senha</th>
 	<th>Data de Inscrição</th>
 	<th>Excluir</th>
 	<th>Alterar</th>
 </tr>
<%
for(Usuario u:listaResultado){
%>
<tr>
 	<th><%=u.getId() %></th>
 	<th><%=u.getNome() %></th>
 	<th><%=u.getIdade() %></th>
 	<th><%=u.getEmail() %></th>
 	<th><%=u.getSenha() %></th>
 	<th><%=u.getDatainscricao() %></th>
 	<th><a href="UsuarioControlador?acao=ex&id=<%=u.getId() %>">Excluir</a>
 	<th><a href="UsuarioControlador?acao=alt&id=<%=u.getId()%>">Alterar</a>
 </tr>
<%
}
%>
</table>
</html>