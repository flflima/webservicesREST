package br.com.dev.cliente;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.com.dev.entidades.Cliente;

public class ClienteTester {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		// adiciona cliente
		incluirCliente(client, "João", 15);
		
		// lista cliente
		listarClientes(client);
		
		// atualiza cliente
		atualizarCliente(client, "1");
	
		// deleta cliente
		excluirCliente(client, "1");
	}

	private static void excluirCliente(Client client, String idCliente) {
		WebTarget target = client.target("http://localhost:8080/clientes/" + idCliente);
		Response response = target.request().delete();
		String retorno = response.readEntity(String.class);
		System.out.println(retorno);
		
		listarClientes(client);
	}

	private static void atualizarCliente(Client client, String idCliente) {
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Maria");
		c.setIdade(26);
		
		WebTarget target = client.target("http://localhost:8080/clientes/" + idCliente);
		Response response = target.request().put(Entity.json(c));
		String retorno = response.readEntity(String.class);
		System.out.println(retorno);

		listarClientes(client);
	}

	private static void incluirCliente(Client client, String nome, int idade) {
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setIdade(idade);
		
		WebTarget target = client.target("http://localhost:8080/clientes");
		Response response = target.request().post(Entity.json(c));
		String retorno = response.readEntity(String.class);
		System.out.println(retorno);
	}

	private static void listarClientes(Client client) {
		WebTarget target = client.target("http://localhost:8080/clientes");
		Response response = target.request().get();
		List<Cliente> clientes = response.readEntity(new GenericType<List<Cliente>>() {});
		imprimirCliente(clientes);
	}

	private static void imprimirCliente(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println("--------------------------------");
			System.out.println(cliente.getId());
			System.out.println(cliente.getNome());
			System.out.println(cliente.getIdade());
			System.out.println("--------------------------------");
		}
	}
}
