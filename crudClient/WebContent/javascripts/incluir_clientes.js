/**
 * 
 */
$(function() {

	$("#bt").click(function() {
		var cliente = {
			"nome" : $("#nomeCliente").val(),
			"idade" : parseInt($("#idadeCliente").val())
		};

		$.ajax({
			url : "http://localhost:8080/crudCliente/crud/clientes",
			type : "POST",
			data : JSON.stringify(cliente),
			contentType : "application/json; charset=utf-8"
		}).done(function(e) {
			console.log("Sucesso! " + e);
		}).fail(function(e) {
			console.log("Erro: " + e);
		});

	});
});