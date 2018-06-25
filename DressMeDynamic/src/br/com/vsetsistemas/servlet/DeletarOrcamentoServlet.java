package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class DeletarPedidoVendaServlet
 */
@WebServlet("/DeletarOrcamentoServlet")
public class DeletarOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidoVendaSession session = new PedidoVendaSession();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarOrcamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session.deletePedidoVenda(session.obtainById(Long.parseLong(request.getParameter("numeroPedido"))));
		
		String nextJSP = "/DressMeDynamic/ListarOrcamentoServlet";
		response.sendRedirect(nextJSP);
       // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        //dispatcher.forward(request, response);

	}

}
