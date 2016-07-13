<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Clientes</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="javascripts/crud_cliente.js" type="text/javascript"></script>
</head>
<body>
	<form method="post" id="formIncluir" >  
		<label>Nome: </label><input type="text" id="nomeCliente" > <br>
		<label>Idade: </label><input type="text" id="idadeCliente" > <br>
		<input type="button" id="btnIncluir" value="Enviar">
	</form>
	<br />
	<a href="http://localhost:8080/crudClient/clientes.jsp">Voltar</a>
</body>
</html>