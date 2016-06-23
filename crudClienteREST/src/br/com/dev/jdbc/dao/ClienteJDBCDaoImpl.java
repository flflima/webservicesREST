package br.com.dev.jdbc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dev.dao.ClienteDao;
import br.com.dev.entidades.Cliente;
import br.com.dev.jdbc.factory.ConnectionFactory;

public class ClienteJDBCDaoImpl implements ClienteDao {

	private Connection connection;

	public ClienteJDBCDaoImpl() {
		this.connection = ConnectionFactory.getConnectionTest();
	}

	@Override
	public void incluirCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, idade) VALUES (?, ?)";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getIdade());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cliente> listarClientes() {
		String sql = "SELECT * FROM cliente order by nome";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setIdade(rs.getInt("idade"));
				
				clientes.add(cliente);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return clientes;
	}

	@Override
	public Cliente buscarCliente(long id) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		Cliente cliente = null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setIdade(rs.getInt("idade"));
				cliente.setNome(rs.getString("nome"));
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cliente;
	}

	@Override
	public void atualizarCliente(Cliente cliente, long id) {
		String sql = "UPDATE cliente SET nome = ?, idade = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getIdade());
			ps.setLong(3, id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removerCliente(long id) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
