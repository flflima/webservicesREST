package br.com.dev.factory;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import br.com.dev.jdbc.factory.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void testGetConnection() {
		Connection connection = ConnectionFactory.getConnection();
		
		assertNotNull(connection);;
	}

}
