<%@page import="br.com.exemplo.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<h1>Curso Java Web!</h1>

<%
//Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
//out.print("Seja bem vindo! ,"+usuAutenticado.getNome());
%>
</body>
</html>