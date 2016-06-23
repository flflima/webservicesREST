package br.com.dev.resources;

import org.junit.Assert;
import org.junit.Test;

import br.com.dev.entidades.Cliente;

public class ClienteResourceTest {

	@Test
	public void testarIncluirCliente() {
		ClienteResource resource = new ClienteResource();

		Cliente cliente = new Cliente();
		cliente.setNome("Fulano Teste");
		cliente.setIdade(15);
		
		resource.incluirCliente(cliente);
		
		Assert.assertNotNull(cliente.getId());
	}

}
