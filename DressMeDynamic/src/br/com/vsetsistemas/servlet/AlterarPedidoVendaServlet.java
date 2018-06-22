package br.com.vsetsistemas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.session.PedidoVendaSession;

/**
 * Servlet implementation class AlterarPedidoVendaServlet
 */
@WebServlet("/AlterarPedidoVendaServlet")
public class AlterarPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarPedidoVendaServlet() {
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
		session.updatePedidoVenda(EditarPedidoVendaServlet.pv);
		
		for(int i = 0; i < EditarPedidoVendaServlet.pv.getListaProduto().size(); i++) {
			EditarPedidoVendaServlet.pv.getListaProduto().get(i).setPedido(EditarPedidoVendaServlet.pv);
			//session.updateProduct(EditarPedidoVendaServlet.pv.getListaProduto().get(i));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
