/**
 * 
 */
$(function() {
	
	$.getJSON("http://localhost:8080/crudCliente/crud/clientes", function(data) {

		$.each(data, function(i, item)
		{
			$("#listaClientes").append("<tr><td>" + item.nome + "</td><td>" + item.idade + "</td></tr>");
		});
	});
});