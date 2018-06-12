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
@WebServlet("/ListarPedidoVendaServlet")
public class ListarPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPedidoVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PedidoVendaSession service = new PedidoVendaSession();
		List<PedidoVenda> lista = service.listAll();
		System.out.println("entrou get");
		//Colocar a lista na memoria
		request.setAttribute("listarPedidosVendas", lista);
		
		String nextJSP = "/listarPedidosVendas.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PedidoVendaSession service = new PedidoVendaSession();
		List<PedidoVenda> lista = service.listAll();
		System.out.println("entrou post");
		//Colocar a lista na memoria
		request.setAttribute("../listarPedidosVendas", lista);
		
		String nextJSP = "/listarPedidosVendas.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

}