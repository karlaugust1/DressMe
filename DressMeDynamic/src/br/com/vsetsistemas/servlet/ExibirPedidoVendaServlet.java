package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class ExibirPedidoVendaServlet
 */
@WebServlet("/ExibirPedidoVendaServlet")
public class ExibirPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExibirPedidoVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PedidoVendaSession session = new PedidoVendaSession();
		PedidoVenda pv = session.obtainById(Long.parseLong(request.getParameter("numero")));
		request.getSession().setAttribute("pedidoVenda", pv);
		
		String nextJSP = "/exibirPedidoVenda.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PedidoVendaSession session = new PedidoVendaSession();
		PedidoVenda pv = session.obtainById(Long.parseLong(request.getParameter("numero")));
		request.getSession().setAttribute("pedidoVenda", pv);
		
		String nextJSP = "/exibirPedidoVenda.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

}
