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
	
	@Test
	public void testar03BuscarCliente() {
		ClienteResource resource = new ClienteResource();

		List<Cliente> clientes = resource.getClientes();
		Cliente cliente = clientes.get(0);
		
		Cliente clienteRecuperado = resource.buscarCliente(cliente.getId());
		
		Assert.assertEquals(cliente.getNome(), clienteRecuperado.getNome());
	}

	@Test
	public void testar04AtualizarCliente() {
		ClienteResource resource = new ClienteResource();
		
		List<Cliente> clientes = resource.getClientes();
		Cliente cliente = clientes.get(0);
		cliente.setNome("Fulano de Tal");
		
		resource.atualizarCliente(cliente, cliente.getId());

		Assert.assertEquals("Fulano de Tal", resource.buscarCliente(cliente.getId()).getNome());
	}
}
