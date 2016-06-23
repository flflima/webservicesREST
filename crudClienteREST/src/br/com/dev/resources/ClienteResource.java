package br.com.dev.resources;

import java.util.List;

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
	private ClienteDao dao;

	public ClienteResource() {
		this.dao = new ClienteJDBCDaoImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes() {
		return dao.listarClientes();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarCliente(@PathParam("id") long id) {
		return dao.buscarCliente(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String incluirCliente(Cliente c) {
		try {
			dao.incluirCliente(c);
			return c.getNome() + " adicionado!";
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "Erro ao incluir";
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarCliente(Cliente c, @PathParam("id") long id) {
		Cliente clienteAtual = dao.buscarCliente(id);
		
		if (clienteAtual == null) {
			return "Cliente id: " + c.getId() + " não foi localizado.";
		}
		
		try {
			clienteAtual.setNome(c.getNome());
			clienteAtual.setIdade(c.getIdade());
			
			dao.atualizarCliente(clienteAtual, id);
			
			return c.getNome() + " atualizado!";
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return "Erro ao atualizar";
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removerCliente(@PathParam("id") long id) {
		Cliente clienteAtual = dao.buscarCliente(id);
		
		if (clienteAtual == null) {
			return "Cliente id: " + id + " não foi localizado.";
		}
		
		try {
			String nomeCliente = clienteAtual.getNome();
			
			dao.removerCliente(id);
			
			return nomeCliente + " removido!";
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "Erro ao remover";
	}
}
