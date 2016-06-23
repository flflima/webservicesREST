package br.com.dev.resources;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dev.dao.ClienteDao;
import br.com.dev.entidades.Cliente;
import br.com.dev.jdbc.dao.ClienteJDBCDaoImpl;

@Path("/clientes")
public class ClienteResource {
	private static Map<Long, Cliente> clientes;
	private static long idCliente;
	
	private ClienteDao dao;

	public ClienteResource() {
		this.dao = new ClienteJDBCDaoImpl();
	}
	
	static {
		clientes = new HashMap<Long, Cliente>();
		idCliente = 1;
		
		Cliente c = new Cliente();
		c.setId(idCliente);
		c.setNome("Fulano");
		c.setIdade(20);
		
		clientes.put(1L, c);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes() {
		return dao.listarClientes();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String incluirCliente(Cliente c) {
		try {
			dao.incluirCliente(c);
			return c.getNome() + " adicionado!";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Erro ao incluir";
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarCliente(Cliente c, @PathParam("id") long id) {
		Cliente clienteAtual = clientes.get(id);
		clienteAtual.setNome(c.getNome());
		clienteAtual.setIdade(c.getIdade());
		return c.getNome() + " atualizado!";
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removerCliente(@PathParam("id") long id) {
		String nomeCliente = clientes.get(id).getNome();
		clientes.remove(id);
		return nomeCliente + " removido!";
	}
}
