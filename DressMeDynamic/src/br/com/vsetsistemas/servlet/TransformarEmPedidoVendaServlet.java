package br.com.vsetsistemas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class TransformarEmPedidoVendaServlet
 */
@WebServlet("/TransformarEmPedidoVendaServlet")
public class TransformarEmPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoVendaSession session = new PedidoVendaSession();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransformarEmPedidoVendaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("inserir") != null) {

			PreOrcamentoServlet.pedidoVenda.setOrcamento(false);
			PreOrcamentoServlet.pedidoVenda.setSituacao("Realizado");
			PreOrcamentoServlet.pedidoVenda.setStatus(true);
			PreOrcamentoServlet.pedidoVenda.setValorTotal(
					PreOrcamentoServlet.pedidoVenda.getValorSubtotal() - PreOrcamentoServlet.pedidoVenda.getDesconto());
			PreOrcamentoServlet.pedidoVenda
					.setNumeroPontos(session.convertIntoPoints(PreOrcamentoServlet.pedidoVenda.getValorTotal()));
			session.insertOrcamento(PreOrcamentoServlet.pedidoVenda);

		} else if (request.getParameter("editar") != null) {
			
			EditarOrcamentoServlet.pv.setOrcamento(false);
			EditarOrcamentoServlet.pv.setSituacao("Realizado");
			EditarOrcamentoServlet.pv.setStatus(true);
			EditarOrcamentoServlet.pv.setValorTotal(
					EditarOrcamentoServlet.pv.getValorSubtotal() - EditarOrcamentoServlet.pv.getDesconto());
			EditarOrcamentoServlet.pv
					.setNumeroPontos(session.convertIntoPoints(EditarOrcamentoServlet.pv.getValorTotal()));

			session.toPedidoVenda(EditarOrcamentoServlet.pv);

		}

		String nextJSP = "/DressMeDynamic/ListarOrcamentoServlet";
		response.sendRedirect(nextJSP);

	}

}
