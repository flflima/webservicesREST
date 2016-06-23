package br.com.dev.resources;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.dev.entidades.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteResourceTest {

	@Test
	public void testar01IncluirCliente() {
		ClienteResource resource = new ClienteResource();

		Cliente cliente = new Cliente();
		cliente.setNome("Fulano Teste");
		cliente.setIdade(15);
		
		resource.incluirCliente(cliente);
		
		Assert.assertNotNull(cliente.getId());
	}
	
	@Test
	public void testar02ListarClientes() {
		ClienteResource resource = new ClienteResource();
		
		List<Cliente> clientes = resource.getClientes();
		
		Assert.assertTrue(clientes.size() > 0);
	}

}
