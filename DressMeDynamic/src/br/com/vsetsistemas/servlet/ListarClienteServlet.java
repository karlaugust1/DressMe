package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.PedidoVendaSession;


/**
 * Servlet implementation class ListarVendasServlet
 */
@WebServlet("/ListarClienteServlet")
public class ListarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteSession cs = new ClienteSession();
		List<Cliente> lista = cs.listAll();
		//Colocar a lista na memoria
		request.setAttribute("listaClientes", lista);
		
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
	
	}

}