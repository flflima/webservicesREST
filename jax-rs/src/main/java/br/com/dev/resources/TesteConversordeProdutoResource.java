package br.com.dev.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.dev.entities.Produto;

public class TesteConversordeProdutoResource {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		Produto p = new Produto();
		p.setId(1L);
		p.setNome("produto-1");
		p.setPreco(50.0);

		System.out.println("==================== XML =====================");
		
		WebTarget target = client.target("http://localhost:8080/produtos/converte/json/xml");
		Response response = target.request().post(Entity.json(p));
		String xml = response.readEntity(String.class);
		System.out.println(xml);

		System.out.println("==================== JSON ====================");
		target = client.target("http://localhost:8080/produtos/converte/xml/json");
		response = target.request().post(Entity.xml(p));
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		System.out.println("==============================================");
	}

}
