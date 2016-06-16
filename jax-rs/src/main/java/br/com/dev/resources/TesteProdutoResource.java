package br.com.dev.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.dev.entities.Produto;

public class TesteProdutoResource {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/produtos/1/xml");
		
		System.out.println("==================== XML =====================");
		Response response = target.request().get();
		String xml = response.readEntity(String.class);
		System.out.println(xml);
		
		response = target.request().get();
		Produto p = response.readEntity(Produto.class);
		System.out.println(p.getId());
		System.out.println(p.getNome());
		System.out.println(p.getPreco());
		
		System.out.println("==================== JSON ====================");

		target = client.target("http://localhost:8080/produtos/1/json");

		response = target.request().get();
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		response = target.request().get();
		p = response.readEntity(Produto.class);
		System.out.println(p.getId());
		System.out.println(p.getNome());
		System.out.println(p.getPreco());

		System.out.println("==============================================");
	}

}
