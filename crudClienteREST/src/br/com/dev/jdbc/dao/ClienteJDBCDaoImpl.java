package br.com.dev.jdbc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dev.dao.ClienteDao;
import br.com.dev.entidades.Cliente;
import br.com.dev.jdbc.factory.ConnectionFactory;

public class ClienteJDBCDaoImpl implements ClienteDao {

	private Connection connection;

	public ClienteJDBCDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
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

}
