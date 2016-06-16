package br.com.dev.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TesteCotacaoResource {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/Cotacao/DollarToReal");
		Response response = target.request().get();
		String cotacao = response.readEntity(String.class);
		System.out.println(cotacao);
	}

}
