/**
 * 
 */
function detalharCliente(id) {
	$.getJSON("http://localhost:8080/crudCliente/crud/clientes/" + id, function(data) {
		
		$("#info_cliente").append("<p><b>Nome: </b>" + data.nome + "</p>")
							.append("<p><b>Idade: </b>" + data.idade + "</p>");		
	});
}

function excluirCliente(id) {
	$.ajax({
		url : "http://localhost:8080/crudCliente/crud/clientes/" + id,
		type : "DELETE",
		contentType : "application/json; charset=utf-8"
	}).done(function(e) {
		$("#info_cliente").append("<p>" + e + "</p>");
	}).fail(function(e) {
		$("#info_cliente").append("<p>" + e + "</p>");
		console.log("Erro: " + e);
	});
}
