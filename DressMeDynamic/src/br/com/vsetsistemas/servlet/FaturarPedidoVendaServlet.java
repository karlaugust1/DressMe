package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class FaturarPedidoVendaServlet
 */
@WebServlet("/FaturarPedidoVendaServlet")
public class FaturarPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteSession cs = new ClienteSession();
	private PedidoVendaSession session = new PedidoVendaSession();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaturarPedidoVendaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("inserir") != null) {

			PrePedidoVendaServlet.pedidoVenda.setOrcamento(false);
			PrePedidoVendaServlet.pedidoVenda.setSituacao("Realizado");
			PrePedidoVendaServlet.pedidoVenda.setStatus(true);
			PrePedidoVendaServlet.pedidoVenda.setValorTotal(PrePedidoVendaServlet.pedidoVenda.getValorSubtotal()
					- PrePedidoVendaServlet.pedidoVenda.getDesconto());
			if (PrePedidoVendaServlet.vlrDesconto != 0) {
				// checkbox checked
				PrePedidoVendaServlet.pedidoVenda.setNumeroPontos(0);
				PrePedidoVendaServlet.pedidoVenda.getCliente().setQtdPontos(0);
				cs.updatePoints(PrePedidoVendaServlet.pedidoVenda.getCliente());

			} else {
				// checkbox not checked
				PrePedidoVendaServlet.pedidoVenda
						.setNumeroPontos(session.convertIntoPoints(PrePedidoVendaServlet.pedidoVenda.getValorTotal()));
				PrePedidoVendaServlet.pedidoVenda.getCliente()
						.setQtdPontos(PrePedidoVendaServlet.pedidoVenda.getNumeroPontos()
								+ PrePedidoVendaServlet.pedidoVenda.getCliente().getQtdPontos());
				cs.updatePoints(PrePedidoVendaServlet.pedidoVenda.getCliente());
			}
			session.insertPedidoVenda(PrePedidoVendaServlet.pedidoVenda);
			for (int i = 0; i < PrePedidoVendaServlet.pedidoVenda.getListaProduto().size(); i++) {
				PrePedidoVendaServlet.pedidoVenda.getListaProduto().get(i).setPedido(PrePedidoVendaServlet.pedidoVenda);
				session.insertProduct(PrePedidoVendaServlet.pedidoVenda.getListaProduto().get(i));
			}
			session.invoicePedidoVenda(PrePedidoVendaServlet.pedidoVenda);

		} else if (request.getParameter("editar") != null) {

			System.out.println("editar");
			EditarPedidoVendaServlet.pv.setOrcamento(false);
			EditarPedidoVendaServlet.pv.setSituacao("Realizado");
			EditarPedidoVendaServlet.pv.setStatus(true);
			EditarPedidoVendaServlet.pv.setValorTotal(
					EditarPedidoVendaServlet.pv.getValorSubtotal() - EditarPedidoVendaServlet.pv.getDesconto());
			if (EditarPedidoVendaServlet.vlrDesconto != 0) {
				// checkbox checked
				System.out.println("checked");
				EditarPedidoVendaServlet.pv.setNumeroPontos(0);
				EditarPedidoVendaServlet.pv.getCliente().setQtdPontos(0);
				cs.updatePoints(EditarPedidoVendaServlet.pv.getCliente());

			} else {
				// checkbox not checked
				System.out.println("unchecked");
				EditarPedidoVendaServlet.pv
						.setNumeroPontos(session.convertIntoPoints(EditarPedidoVendaServlet.pv.getValorTotal()));
				EditarPedidoVendaServlet.pv.getCliente().setQtdPontos(EditarPedidoVendaServlet.pv.getNumeroPontos()
						+ EditarPedidoVendaServlet.pv.getCliente().getQtdPontos());
				cs.updatePoints(EditarPedidoVendaServlet.pv.getCliente());
			}
			// session.insertPedidoVenda(EditarPedidoVendaServlet.pv);
			for (int i = 0; i < EditarPedidoVendaServlet.pv.getListaProduto().size(); i++) {
				EditarPedidoVendaServlet.pv.getListaProduto().get(i).setPedido(EditarPedidoVendaServlet.pv);
				session.insertProduct(EditarPedidoVendaServlet.pv.getListaProduto().get(i));
			}
			session.invoicePedidoVenda(EditarPedidoVendaServlet.pv);

		}

		request.getSession().removeAttribute("cliente");
		request.getSession().removeAttribute("vendedor");
		request.getSession().removeAttribute("condPag");
		request.getSession().removeAttribute("listaProdutosPedidoVenda");
		request.getSession().removeAttribute("subTotal");
		request.getSession().removeAttribute("desconto");

		/*String nextJSP = "/ListarPedidoVendaServlet";
		//String nextJSP = "/EmitirNotaServlet";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response)*/;
		String nextJSP = "/DressMeDynamic/ListarPedidoVendaServlet";
		response.sendRedirect(nextJSP);
	}

}
