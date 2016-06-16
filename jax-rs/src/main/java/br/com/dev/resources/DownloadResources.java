package br.com.dev.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class DownloadResources {

	@GET
	@Path("/texto")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTexto() {
		File file = new File("texto.txt");
		
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"texto.txt\"");
		
		return response.build();
	}
	
	@GET
	@Path("/arquivo")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPdf() {
		File file = new File("arq.pdf");
		
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"arq.pdf\"");
		
		return response.build();
	}
}
