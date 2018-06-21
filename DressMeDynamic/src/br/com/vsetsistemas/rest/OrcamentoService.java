package br.com.vsetsistemas.rest;

import java.util.ArrayList;
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

import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

@Path("/orcamento")
public class OrcamentoService {
	
	PedidoVendaSession session = new PedidoVendaSession();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadInitialParameters() {
		
		PedidoVenda pv = null;
		pv = session.loadInitialParameters();
		pv.setOrcamento(true);
		return Response.status(200).entity(pv).build();
	}

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

		List<PedidoVenda> lista = session.listAllBudges();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Lista vazia").build();
		}
		return Response.status(200).entity(lista).build();
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOrcamento(PedidoVenda pv){
		
		String result = "Orçamento inserido com sucesso";
		
		if(this.session.insertOrcamento(pv)){			
			return Response.status(201).entity(result).build();
		}
		
		result = "Orçamento não foi inserido com sucesso";
		return Response.status(400).entity(result).build();
	}
	
	@POST
	@Path("/insert/iten")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirProduto(Item i) {
						
			session.insertProduct(i);
			String sum = "Inserido com sucesso";
			return Response.status(200).entity(sum).build();
	}
	
	@GET
	@Path("list/itens")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listItens(PedidoVenda pv){
		
		List<Item> itemList = new ArrayList<>();
		itemList = this.session.listAllProduct(pv);
		return Response.status(200).entity(itemList).build();
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrcamento(PedidoVenda pv){
		
		String result = "Orçamento alterado com sucesso";
		if(this.session.updatePedidoVenda(pv)){
			return Response.status(201).entity(result).build();			
		}
		result = "Orçamento não foi alterado com sucesso";
		return Response.status(400).entity(result).build();	
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOrcamento(@QueryParam("numero") Long numero){
		
		PedidoVenda pv = new PedidoVenda();
		pv.setNumero(numero);
		String result = "Orçamento excluido com sucesso";
		if(session.deletePedidoVenda(pv)) {
			return Response.status(200).entity(result).build();
		}else {
			result = "Orçamento não foi excluido com sucesso";
			return Response.status(400).entity(result).build();
		}
	}
	

	@POST
	@Path("/pedidovenda")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response toPedidoVenda(PedidoVenda pv) {
		
		String result = "";
		if(this.session.toPedidoVenda(pv)) {
			result = "Pedido de venda faturado com sucesso!";			
		}else {
			result = "Pedido de venda não foi faturado com sucesso!";
		}
		return Response.status(200).entity(result).build();
	}
}
