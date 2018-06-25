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
@WebServlet("/InserirPedidoVendaServlet")
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
		
		PrePedidoVendaServlet.pedidoVenda.setOrcamento(false);
		PrePedidoVendaServlet.pedidoVenda.setSituacao("Realizado");
		PrePedidoVendaServlet.pedidoVenda.setStatus(true);
		PrePedidoVendaServlet.pedidoVenda.setValorTotal(PrePedidoVendaServlet.pedidoVenda.getValorSubtotal() - PrePedidoVendaServlet.pedidoVenda.getDesconto());
		PrePedidoVendaServlet.pedidoVenda.setNumeroPontos(session.convertIntoPoints(PrePedidoVendaServlet.pedidoVenda.getValorTotal()));
		
		session.insertPedidoVenda(PrePedidoVendaServlet.pedidoVenda);
		
		for(int i = 0; i < PrePedidoVendaServlet.pedidoVenda.getListaProduto().size(); i++) {
			PrePedidoVendaServlet.pedidoVenda.getListaProduto().get(i).setPedido(PrePedidoVendaServlet.pedidoVenda);
			session.insertProduct(PrePedidoVendaServlet.pedidoVenda.getListaProduto().get(i));
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
		String nextJSP = "/DressMeDynamic/ListarPedidoVendaServlet";
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
