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
				var linkDetalhar = "<td><a href='http://localhost:8080/crudCliente/detalhar_cliente.html?id=" + item.id + "'>Detalhar</a></td>";
				$("#listaClientes").append("<tr>" + dados + linkDetalhar + "</tr>");
			});
		});
	}
	
	$(window).load(carregarClientes);
});