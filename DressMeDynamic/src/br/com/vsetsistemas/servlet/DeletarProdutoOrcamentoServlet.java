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
@WebServlet("/DeletarProdutoOrcamentoServlet")
public class DeletarProdutoOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoWebService pws = new ProdutoWebService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarProdutoOrcamentoServlet() {
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
		
		for(Item i : PreOrcamentoServlet.pedidoVenda.getListaProduto()) {
			if(i.getId() == idItem) {
				PreOrcamentoServlet.pedidoVenda.getListaProduto().remove(i);
				InserirProdutoOrcamentoServlet.listaProdutosPedidoVenda.remove(i);
				i.setQuantidade(i.getQuantidade()*-1);
				pws.atualizarEstoque(i);
				break;
			}
		}
		
		Double subTotal = 0.0;
		
		for(Item item : InserirProdutoOrcamentoServlet.listaProdutosPedidoVenda) {
			subTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
				
		DecimalFormat dfmt = new DecimalFormat("0.00");
		//
		PreOrcamentoServlet.pedidoVenda.setValorSubtotal(subTotal);
		PreOrcamentoServlet.pedidoVenda.setValorTotal(subTotal - PreOrcamentoServlet.pedidoVenda.getDesconto());
		//
		request.getSession().setAttribute("subTotal", dfmt.format(subTotal));
		
		/*String nextJSP = "/PreOrcamentoServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);*/
		String nextJSP = "/DressMeDynamic/PreOrcamentoServlet";
		response.sendRedirect(nextJSP);
		
	}

}
