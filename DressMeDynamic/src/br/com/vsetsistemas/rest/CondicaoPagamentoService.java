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

import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.session.CondicaoPagamentoSession;

@Path("/condicaoPagamento")
public class CondicaoPagamentoService {
	
	CondicaoPagamentoSession session = new CondicaoPagamentoSession();

	@GET
	@Path("/obtain")
	@Produces(MediaType.APPLICATION_JSON)
	public CondicaoPagamento obtain(@QueryParam("id")int id) {
	
		CondicaoPagamento cp = session.obtainById(id);
		return cp;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CondicaoPagamento> listAll() {

		List<CondicaoPagamento> lista = session.listAll();
		
		return lista;
	}
	
}
