package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.services.ProdutoWebService;


/**
 * Servlet implementation class DeletarProdutoServlet
 */
@WebServlet("/DeletarProdutoServlet")
public class DeletarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoWebService pws = new ProdutoWebService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long idItem = Long.parseLong(request.getParameter("idProduto"));
		
		for(Item i : PrePedidoVendaServlet.pedidoVenda.getListaProduto()) {
			if(i.getId() == idItem) {
				PrePedidoVendaServlet.pedidoVenda.getListaProduto().remove(i);
				InserirProdutoServlet.listaProdutosPedidoVenda.remove(i);
				i.setQuantidade(i.getQuantidade()*-1);
				pws.atualizarEstoque(i);
				break;
			}
		}
		
		Double subTotal = 0.0;
		
		for(Item item : InserirProdutoServlet.listaProdutosPedidoVenda) {
			subTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
				
		DecimalFormat dfmt = new DecimalFormat("0.00");
		//
		PrePedidoVendaServlet.pedidoVenda.setValorSubtotal(subTotal);
		PrePedidoVendaServlet.pedidoVenda.setValorTotal(subTotal - PrePedidoVendaServlet.pedidoVenda.getDesconto());
		//
		request.getSession().setAttribute("subTotal", dfmt.format(subTotal));
		
		/*String nextJSP = "/PrePedidoVendaServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);*/
		String nextJSP = "/DressMeDynamic/PrePedidoVendaServlet";
		response.sendRedirect(nextJSP);
		
	}

}
