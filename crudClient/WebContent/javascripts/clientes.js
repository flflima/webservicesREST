/**
 * 
 */
$(function() {
	
	function carregarClientes() {
		$.getJSON("http://localhost:8080/crudCliente/crud/clientes", function(data) {
			
			$.each(data, function(i, item)
			{
				var dados = "<td>" + item.nome + "</td><td>" + item.idade + "</td>";
				console.log("http://localhost:8080/crudCliente/crud/clientes/" + item.id);
				var linkDetalhar = "<td><a href='http://localhost:8080/crudClient/detalhar_cliente.jsp?id=" + item.id + "'>Detalhar</a></td>";
				var linkExcluir = "<td><a href='http://localhost:8080/crudClient/excluir_cliente.jsp?id=" + item.id + "'>Excluir</a></td>";
				$("#listaClientes").append("<tr>" + dados + linkDetalhar + linkExcluir + "</tr>");
			});
		});
	}
	
	$(window).load(carregarClientes);
});