package br.com.dev.main;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class Publicador {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws IOException, IllegalArgumentException {
		System.out.println("Publicando o webservice...");
		
		ResourceConfig rc = new ResourceConfig().packages(new String[] {"br.com.dev.resources"});
		
		HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);
		
		System.out.println("Sucesso");
	}

}
