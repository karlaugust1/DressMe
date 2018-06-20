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
import br.com.vsetsistemas.session.ProdutoSession;


/**
 * Servlet implementation class InserirProdutoServlet
 */
@WebServlet("/InserirProdutoServlet")
public class InserirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
      private List<Item> listaProdutosPedidoVenda = new ArrayList<>();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirProdutoServlet() {
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
		
		PrePedidoVendaServlet.pedidoVenda.setListaProduto(listaProdutosPedidoVenda);
		
		DecimalFormat dfmt = new DecimalFormat("0.00");
		request.getSession().setAttribute("listaProdutosPedidoVenda", listaProdutosPedidoVenda);
		request.getSession().setAttribute("subTotal", dfmt.format(subTotal));
		PrePedidoVendaServlet.pedidoVenda.setValorSubtotal(subTotal);
		
		
		String nextJSP = "/PrePedidoVendaServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
	}

}
