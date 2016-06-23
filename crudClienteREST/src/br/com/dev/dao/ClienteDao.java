package br.com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dev.entidades.Cliente;

public interface ClienteDao {

	void incluirCliente(Cliente cliente) throws SQLException;
	
	List<Cliente> listarClientes();
	
	Cliente buscarCliente(long id);
	
	void atualizarCliente(Cliente cliente, long id);
	
	void removerCliente(long id);
}
