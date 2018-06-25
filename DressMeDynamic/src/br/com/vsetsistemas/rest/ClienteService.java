package br.com.vsetsistemas.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.session.ClienteSession;

@Path("/cliente")
public class ClienteService {
	
	private ClienteSession session = new ClienteSession();
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {

		List<Cliente> lista = session.listAll();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Sem clientes cadastrados!").build();
		}
		return Response.status(200).entity(lista).build();
	}
}
