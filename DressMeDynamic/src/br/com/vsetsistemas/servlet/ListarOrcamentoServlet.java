package br.com.vsetsistemas.servlet;

import java.io.IOException;
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
 * Servlet implementation class ListarVendasServlet
 */
@WebServlet("/ListarOrcamentoServlet")
public class ListarOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarOrcamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PedidoVendaSession service = new PedidoVendaSession();
		List<PedidoVenda> lista = service.listAllBudges();
		
		//Colocar na memoria
		request.setAttribute("listarOrcamentos", lista);
		request.getSession().removeAttribute("cliente");
		request.getSession().removeAttribute("vendedor");
		request.getSession().removeAttribute("condPag");
		request.getSession().removeAttribute("listaProdutosOrcamento");
		request.getSession().removeAttribute("subTotal");
		request.getSession().removeAttribute("desconto");
		request.getSession().removeAttribute("utilizar");
		//PrePedidoVendaServlet.pedidoVenda = new PedidoVenda();
		PedidoVendaSession session = new PedidoVendaSession();
		PreOrcamentoServlet.pedidoVenda = session.loadInitialParameters();
		EditarOrcamentoServlet.pv = new PedidoVenda();

		String nextJSP = "/listarOrcamentos.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
	}

}