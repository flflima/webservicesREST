/**
 * 
 */
function detalharCliente(id) {
	$.getJSON("http://localhost:8080/crudCliente/crud/clientes/" + id, function(data) {
		
		$("#info_cliente").append("<p><b>Nome: </b>" + data.nome + "</p>")
							.append("<p><b>Idade: </b>" + data.idade + "</p>");		
	});
}
