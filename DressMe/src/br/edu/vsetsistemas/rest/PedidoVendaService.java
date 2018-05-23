package br.edu.vsetsistemas.rest;

import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

public class PedidoVendaService {
	
	PedidoVendaSession session = new PedidoVendaSession();

	@GET
	@Path("/pedidovenda")
	@Produces(MediaType.APPLICATION_JSON)
	public PedidoVenda obterPorId(@QueryParam("numero")long numero) {
	
		PedidoVenda pv = session.obtainById(numero);
		return pv;
	}
}
