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
 * Servlet implementation class InserirProdutoServlet
 */
@WebServlet("/InserirProdutoServlet")
public class InserirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		/*PedidoVendaSession pvs = new PedidoVendaSession();
		pvs.inser
		condPag = cps.obtainById(new Integer(0).parseInt(request.getParameter("idCP")));
		request.getSession().setAttribute("condPag", condPag);
		
		String nextJSP = "/PrePedidoVendaServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);*/
	}

}
