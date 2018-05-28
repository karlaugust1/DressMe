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

import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

@Path("/pedidovenda")
public class PedidoVendaService {
	
	PedidoVendaSession session = new PedidoVendaSession();

	@GET
	@Path("/obtain")
	@Produces(MediaType.APPLICATION_JSON)
	public PedidoVenda obterPorId(@QueryParam("numero")long numero) {
	
		PedidoVenda pv = session.obtainById(numero);
		return pv;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {

		List<PedidoVenda> lista = session.listAll();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Lista vazia").build();
		}
		return Response.status(200).entity(lista).build();
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirPedidoVenda(PedidoVenda pv){
		
		String result = "Pedido de venda inserido com sucesso";
		
		if(this.session.insertPedidoVenda(pv)){			
			return Response.status(201).entity(result).build();
		}
		
		result = "Pedido de venda n�o foi inserido com sucesso";
		return Response.status(400).entity(result).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePedidoVenda(PedidoVenda pv){
		
		String result = "Pedido de venda alterado com sucesso";
		if(this.session.updatePedidoVenda(pv)){
			return Response.status(201).entity(result).build();			
		}
		result = "Pedido de venda n�o foi alterado com sucesso";
		return Response.status(400).entity(result).build();	
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletePedidoVenda(@QueryParam("numero") Long numero){
		
		PedidoVenda pv = new PedidoVenda();
		pv.setNumero(numero);
		String result = "Pedido de venda excluido com sucesso";
		if(session.deletePedidoVenda(pv)) {
			return Response.status(200).entity(result).build();
		}else {
			result = "Pedido de venda n�o foi excluido com sucesso";
			return Response.status(400).entity(result).build();
		}
	}
}
