/**
 * 
 */
$(function() {
	
	function carregarClientes() {
		$.getJSON("http://localhost:8080/crudCliente/crud/clientes", function(data) {
			
			$.each(data, function(i, item)
			{
				var id = item.id;
				var nome = item.nome;
				var idade = item.idade;
				
				var linkDetalhar = "<a href='http://localhost:8080/crudClient/detalhar_cliente.jsp?id=" + id + "'>";
				var linkExcluir = "<td><a href='http://localhost:8080/crudClient/excluir_cliente.jsp?id=" + id + "'>Excluir</a></td>";
				
				var colunaNome = "<td>" + linkDetalhar + nome + "</a>";
				var colunaIdade = "<td>" + idade + "</td>";
				
				$("#listaClientes").append("<tr>" + colunaNome + colunaIdade + linkExcluir + "</tr>");
			});
		});
	}
	
	$(window).load(carregarClientes);
});