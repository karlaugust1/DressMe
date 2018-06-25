package br.com.vsetsistemas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.services.ProdutoWebService;

/**
 * Servlet implementation class CancelarPedidoVendaServlet
 */
@WebServlet("/CancelarPedidoVendaServlet")
public class CancelarPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarPedidoVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoWebService pws = new ProdutoWebService();
		
		if(request.getParameter("pedidoVenda") != null) {
			for(Item i:PrePedidoVendaServlet.pedidoVenda.getListaProduto()) {
				i.setQuantidade(i.getQuantidade()*-1);
				pws.atualizarEstoque(i);
			}
		}
		
		request.getSession().removeAttribute("cliente");
		request.getSession().removeAttribute("vendedor");
		request.getSession().removeAttribute("condPag");
		request.getSession().removeAttribute("listaProdutosPedidoVenda");
		request.getSession().removeAttribute("subTotal");
		request.getSession().removeAttribute("desconto");
		request.getSession().removeAttribute("utilizar");
		
		String nextJSP = "/DressMeDynamic/ListarPedidoVendaServlet";
		response.sendRedirect(nextJSP);
	}

}
