package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class InserirPedidoVendaServlet
 */
@WebServlet("/InserirOrcamentoServlet")
public class InserirOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirOrcamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PedidoVendaSession session = new PedidoVendaSession();
		
		PreOrcamentoServlet.pedidoVenda.setOrcamento(true);
		PreOrcamentoServlet.pedidoVenda.setSituacao("Orçamento");
		PreOrcamentoServlet.pedidoVenda.setStatus(true);
		PreOrcamentoServlet.pedidoVenda.setValorTotal(PreOrcamentoServlet.pedidoVenda.getValorSubtotal() - PreOrcamentoServlet.pedidoVenda.getDesconto());
		PreOrcamentoServlet.pedidoVenda.setNumeroPontos(session.convertIntoPoints(PreOrcamentoServlet.pedidoVenda.getValorTotal()));
		
		session.insertOrcamento(PreOrcamentoServlet.pedidoVenda);
		
		for(int i = 0; i < PreOrcamentoServlet.pedidoVenda.getListaProduto().size(); i++) {
			PreOrcamentoServlet.pedidoVenda.getListaProduto().get(i).setPedido(PreOrcamentoServlet.pedidoVenda);
			session.insertProduct(PreOrcamentoServlet.pedidoVenda.getListaProduto().get(i));
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
