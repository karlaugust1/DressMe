package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.session.ClienteSession;

/**
 * Servlet implementation class inserirClienteServlet
 */
@WebServlet("/InserirClienteServlet")
public class InserirClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Cliente cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirClienteServlet() {
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

		//Cliente c = new Cliente();
		//c.setId((long) request.getAttribute("idCliente"));
		//System.out.println("Parameter: " + request.getParameter("idCliente"));
		ClienteSession cs = new ClienteSession();
		cliente = cs.obtainById(new Long(0).parseLong(request.getParameter("idCliente")));
		request.getSession().setAttribute("cliente", cliente);
		
		String nextJSP = "/PrePedidoVendaServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
	
}
