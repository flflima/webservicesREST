package br.com.dev.dao;

import java.util.List;

import br.com.dev.entidades.Cliente;

public interface ClienteDao {

	void incluirCliente(Cliente cliente);
	
	List<Cliente> listarClientes();
	
	void atualizarCliente(Cliente cliente, long id);
}
