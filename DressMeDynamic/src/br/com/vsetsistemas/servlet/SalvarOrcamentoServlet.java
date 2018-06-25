package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class SalvarPedidoVendaServlet
 */
@WebServlet("/SalvarOrcamentoServlet")
public class SalvarOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarOrcamentoServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PedidoVendaSession session = new PedidoVendaSession();

		EditarOrcamentoServlet.pv.setValorTotal(EditarOrcamentoServlet.pv.getValorSubtotal() - EditarOrcamentoServlet.pv.getDesconto());
		EditarOrcamentoServlet.pv.setNumeroPontos(session.convertIntoPoints(EditarOrcamentoServlet.pv.getValorTotal()));

		session.updatePedidoVenda(EditarOrcamentoServlet.pv);

		session.deleteProdutoPedido(EditarOrcamentoServlet.pv);
		for (int i = 0; i < EditarOrcamentoServlet.pv.getListaProduto().size(); i++) {
			EditarOrcamentoServlet.pv.getListaProduto().get(i).setPedido(EditarOrcamentoServlet.pv);
			session.insertProduct(EditarOrcamentoServlet.pv.getListaProduto().get(i));
		}

		request.getSession().removeAttribute("cliente");
		request.getSession().removeAttribute("vendedor");
		request.getSession().removeAttribute("condPag");
		request.getSession().removeAttribute("listaProdutosPedidoVenda");
		request.getSession().removeAttribute("subTotal");
		request.getSession().removeAttribute("desconto");

		/*String nextJSP = "/ListarPedidoVendaServlet";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);*/
		
		String nextJSP = "/DressMeDynamic/ListarOrcamentoServlet";
		response.sendRedirect(nextJSP);
	}

}
