package br.com.vsetsistemas.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.Produto;
import br.com.vsetsistemas.session.ProdutoSession;

@Path("/produto")
public class ProdutoService {
	
	private ProdutoSession session = new ProdutoSession();
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {

		List<Produto> lista = session.listAll();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Sem produtos cadastrados!").build();
		}
		return Response.status(200).entity(lista).build();
	}
	
	@POST
	@Path("/atualizarEstoque")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarCliente(Item i){
		
		session.updateEstoque(i);
		String result = "Alterado com sucesso";
		return Response.status(201).entity(result).build();
	}
}