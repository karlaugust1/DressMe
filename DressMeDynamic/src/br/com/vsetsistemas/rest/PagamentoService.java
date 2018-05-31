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

import br.com.vsetsistemas.model.Pagamento;
import br.com.vsetsistemas.session.PagamentoSession;

@Path("/Pagamento")
public class PagamentoService {
	
	PagamentoSession session = new PagamentoSession();

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirPagamento(Pagamento p){
		
		String result = "Pagamento inserido com sucesso";
		
		if(session.insertPagamento(p)){			
			return Response.status(201).entity(result).build();
		}
		
		result = "Pagamento não foi inserido com sucesso";
		return Response.status(400).entity(result).build();
	}
	
}

