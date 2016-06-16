package br.com.dev.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dev.entities.Produto;

@Path("/produtos")
public class ProdutoResource {
	
	private Produto geraProdutoFalso(long id) {
		Produto p = new Produto();
		p.setNome("produto-" + id);
		p.setPreco(50.0 * id);
		p.setId(id);
		
		return p;
	}
	
	@GET
	@Path("/{id}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Produto getProdutoAsXML(@PathParam("id") long id) {
		return this.geraProdutoFalso(id);
	}
	
	@GET
	@Path("/{id}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProdutoAsJson(@PathParam("id")long id) {
		return this.geraProdutoFalso(id);
	}
}
