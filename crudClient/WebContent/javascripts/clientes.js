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
				
				var linkExcluir = "<td><a href='http://localhost:8080/crudClient/excluir_cliente.jsp?id=" + id + "'><img src='/crudClient/img/delete.png' height='15' width='15' title='Excluir'></a></td>";
				var linkEditar = "<td><a href='http://localhost:8080/crudClient/editar_cliente.jsp?id=" + id + "'><img src='/crudClient/img/editar.png' height='15' width='15' title='Editar'></a></td>";
				
				var colunaNome = "<td>" + nome+ "</td>";
				var colunaIdade = "<td>" + idade + "</td>";
				
				$("#listaClientes").append("<tr onclick=\"location.href=" + "'http://localhost:8080/crudClient/detalhar_cliente.jsp?id=" + id +"'\">" + colunaNome + colunaIdade + linkExcluir + linkEditar + "</tr>");
			});
		});
	}
	
	$(window).load(carregarClientes);
});
