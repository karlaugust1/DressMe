package br.com.vsetsistemas.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vsetsistemas.model.Permissao;
import br.com.vsetsistemas.session.PermissaoSession;

@Path("/Permissao")
public class PermissaoService {
	
	PermissaoSession session = new PermissaoSession();

	@GET
	@Path("/obtain")
	@Produces(MediaType.APPLICATION_JSON)
	public Permissao obtainById(@QueryParam("numero")int numero) {
	
		Permissao p = session.obtainById(numero);
		return p;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {

		List<Permissao> lista = session.listAll();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Sem permissões registradas!").build();
		}
		return Response.status(200).entity(lista).build();
	}
	
}
