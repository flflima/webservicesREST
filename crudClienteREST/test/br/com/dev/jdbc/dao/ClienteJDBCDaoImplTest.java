package br.com.dev.jdbc.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.dev.entidades.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteJDBCDaoImplTest {

	@Test
	public void teste01IncluirCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();
		Cliente cliente = new Cliente();
		cliente.setNome("Fulano Teste");
		cliente.setIdade(15);
		
		dao.incluirCliente(cliente);
		
		Assert.assertNotNull(cliente.getId());
	}
	
	@Test
	public void teste02ListarClientes() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();
		
		List<Cliente> clientes = dao.listarClientes();
		
		Assert.assertTrue(clientes.size() > 0);
	}
	
	@Test 
	public void teste03BuscarCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();

		List<Cliente> clientes = dao.listarClientes();
		
		Cliente cliente = clientes.get(0);

		Cliente clienteRecuperado = dao.buscarCliente(cliente.getId());
		
		Assert.assertEquals(cliente.getNome(), clienteRecuperado.getNome());
		
	}
	
	@Test
	public void teste04AtualizarCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Fulano de Tal");
		cliente.setIdade(15);
		
		List<Cliente> clientes = dao.listarClientes();
		Cliente ultimoClienteIncluido = clientes.get(clientes.size() - 1);
		
		dao.atualizarCliente(cliente, ultimoClienteIncluido.getId());
		
		ultimoClienteIncluido = dao.buscarCliente(ultimoClienteIncluido.getId());
		
		Assert.assertEquals("Fulano de Tal", ultimoClienteIncluido.getNome());
	}
	
	@Test
	public void teste05RemoverCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();

		List<Cliente> clientes = dao.listarClientes();
		Cliente ultimoCliente = clientes.get(clientes.size() - 1);
		long idUltimoCliente = ultimoCliente.getId();
		
		dao.removerCliente(idUltimoCliente);
		
		Assert.assertNull(dao.buscarCliente(idUltimoCliente));
	}

}
