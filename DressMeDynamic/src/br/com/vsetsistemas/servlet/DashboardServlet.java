package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vsetsistemas.app.UtilApp;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.FuncionarioSession;
import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		Funcionario f = new Funcionario();
		f.setEmail(request.getParameter("email"));
		f.setSenha(request.getParameter("senha"));
	
		FuncionarioSession fsession = new FuncionarioSession();
		
		if(fsession.authenticateFuncionario(f)) {
			
			PedidoVendaSession ps = new PedidoVendaSession();
			ClienteSession cs = new ClienteSession();
			List<PedidoVenda> listaPedidos = null;
			listaPedidos = ps.listAll();
			request.getSession().setAttribute("clientes", cs.countClientes());
			request.getSession().setAttribute("pedidos", ps.countPedidoVendas());
			request.getSession().setAttribute("pedidosMes",ps.countPedidoVendasMes());
			request.getSession().setAttribute("total", ps.sumAllValues());
			request.getSession().setAttribute("listaPedidos", listaPedidos);
			RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
