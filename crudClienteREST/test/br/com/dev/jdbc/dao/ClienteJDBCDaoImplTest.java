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
	public void testIncluirCliente() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();
		Cliente cliente = new Cliente();
		cliente.setNome("Fulano Teste");
		cliente.setIdade(15);
		
		dao.incluirCliente(cliente);
		
		Assert.assertNotNull(cliente.getId());
	}
	
	@Test
	public void testListarClientes() {
		ClienteJDBCDaoImpl dao = new ClienteJDBCDaoImpl();

		Cliente cliente = new Cliente();
		cliente.setNome("Fulano Teste");
		cliente.setIdade(15);
		
		dao.incluirCliente(cliente);
		
		List<Cliente> clientes = dao.listarClientes();
		
		Assert.assertTrue(clientes.size() > 0);
		
	}

}
