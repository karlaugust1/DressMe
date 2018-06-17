package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class prePedidoVendaServlet
 */
@WebServlet("/PrePedidoVendaServlet")
public class PrePedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrePedidoVendaServlet() {
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
		PedidoVenda pv = session.loadInitialParameters();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		ClienteSession cs = new ClienteSession();
		List<Cliente> listaClientes = cs.listAll();
		
		request.getSession().setAttribute("numeroPedido", pv.getNumero()+1);
		request.getSession().setAttribute("dataPedido", format.format(pv.getDataAbertura()));
		request.getSession().setAttribute("listaClientes", listaClientes);
		
		String nextJSP = "/inserirPedidoVenda.jsp";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
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
