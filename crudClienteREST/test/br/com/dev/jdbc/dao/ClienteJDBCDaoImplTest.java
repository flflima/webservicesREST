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
	public void teste03AtualizarCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Fulano de Tal");
		cliente.setIdade(15);
		
		List<Cliente> clientes = dao.listarClientes();
		Cliente ultimoClienteIncluido = clientes.get(clientes.size() - 1);
		
		dao.atualizarCliente(cliente, ultimoClienteIncluido.getId());
		
		clientes = dao.listarClientes();
		ultimoClienteIncluido = clientes.get(clientes.size() - 1);
		
		Assert.assertEquals("Fulano de Tal", ultimoClienteIncluido.getNome());
	}

}
