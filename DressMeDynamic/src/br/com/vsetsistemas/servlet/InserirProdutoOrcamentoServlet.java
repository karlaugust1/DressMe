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
import br.com.vsetsistemas.session.ProdutoSession;


/**
 * Servlet implementation class InserirProdutoServlet
 */
@WebServlet("/InserirProdutoOrcamentoServlet")
public class InserirProdutoOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
      public static List<Item> listaProdutosPedidoVenda = new ArrayList<>();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirProdutoOrcamentoServlet() {
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
		//doGet(request, response);

		
		ProdutoSession ps = new ProdutoSession();
		Item i = new Item();
		
		i.setProduto(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))));
		i.setQuantidade(Integer.parseInt(request.getParameter("qtdProduto")));//implementação do código de getParameter
		i.setId(listaProdutosPedidoVenda.size()+1);
		i.setValorUnitario(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))).getPreco());
		i.setSubtotal(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))).getPreco()*Integer.parseInt(request.getParameter("qtdProduto")));
			
		listaProdutosPedidoVenda.add(i);
		Double subTotal = 0.0;
		
		for(Item item : listaProdutosPedidoVenda) {
			subTotal += item.getProduto().getPreco() * item.getQuantidade();
		}
		
		PreOrcamentoServlet.pedidoVenda.setValorSubtotal(subTotal);
		PreOrcamentoServlet.pedidoVenda.setValorTotal(subTotal - PreOrcamentoServlet.pedidoVenda.getDesconto());
		PreOrcamentoServlet.pedidoVenda.setListaProduto(listaProdutosPedidoVenda);
		
		ProdutoWebService pws = new ProdutoWebService();
		pws.atualizarEstoque(i);
		
		DecimalFormat dfmt = new DecimalFormat("0.00");
		request.getSession().setAttribute("listaProdutosPedidoVenda", listaProdutosPedidoVenda);
		request.getSession().setAttribute("subTotal", dfmt.format(subTotal));
		
		
		/*String nextJSP = "/PreOrcamentoServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);*/
		String nextJSP = "/DressMeDynamic/PreOrcamentoServlet";
		response.sendRedirect(nextJSP);
		
	}

}
