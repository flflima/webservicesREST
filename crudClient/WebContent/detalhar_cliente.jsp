<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clientes</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="javascripts/detalhar_cliente.js" type="text/javascript"></script>
</head>
<body>
	<c:set var="cliente" value="${param.id}"></c:set>
	<h1>Detalhes Cliente</h1>
	<div id="info_cliente">	</div>
	<script>
		detalharCliente('${cliente}');
	</script>
</body>
</html>