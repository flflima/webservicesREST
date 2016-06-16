package br.com.dev.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dev.entities.Produto;

/**
 * 
 * Converte JSON para XML e vice versa.
 *
 */
@Path("/produtos/converte")
public class ConversorDeProdutoResource {

	@POST
	@Path("/json/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Produto transformToXML(Produto p) {
//		<produto>
//		<id>1</id>
//		<nome>produto1</nome>
//		<preco>50.0</preco>
//		</produto>
		return p;
	}
	
	@POST
	@Path("/xml/json")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Produto transformToJSON(Produto p) {
//		{"id":"1","nome":"produto1","preco":"50.0"}
		return p;
	}
}
