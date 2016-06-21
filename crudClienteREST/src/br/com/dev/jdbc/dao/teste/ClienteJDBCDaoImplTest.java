package br.com.dev.jdbc.dao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.dev.entidades.Cliente;
import br.com.dev.jdbc.dao.ClienteJDBCDaoImpl;

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

}
