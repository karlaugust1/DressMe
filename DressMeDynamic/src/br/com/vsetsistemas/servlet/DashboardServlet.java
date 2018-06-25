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
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean logar = true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PedidoVendaSession ps = new PedidoVendaSession();
		ClienteSession cs = new ClienteSession();
		List<PedidoVenda> listaPedidos = null;
		listaPedidos = ps.listAll();
		
		request.getSession().setAttribute("clientes", cs.countClientes());
		request.getSession().setAttribute("pedidos", ps.countPedidoVendas());
		request.getSession().setAttribute("pedidosMes",ps.countPedidoVendasMes());
		request.getSession().setAttribute("total", ps.sumAllValues());
		request.getSession().setAttribute("listaPedidos", listaPedidos);
		
		String nextJSP = "/index2.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
