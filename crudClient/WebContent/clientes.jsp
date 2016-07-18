<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Clientes</title>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="javascripts/clientes.js" type="text/javascript"></script>
	<link type='text/css' href='css/clientes.css' rel='stylesheet'>
</head>
<body>
	<h1 id="titulo">Clientes</h1>
	<div id="divNovoCliente">
		<a href="http://localhost:8080/crudClient/incluir_cliente.jsp" id="novoCliente">Novo Cliente</a>
	</div>
	<table id="listaClientes">
		<tr>
			<th>Nome</th>
			<th>Idade</th>
		</tr>
	</table>
</body>
</html>