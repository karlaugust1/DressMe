package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

/**
 * Servlet implementation class InserirVendedorServlet
 */
@WebServlet("/InserirVendedorServlet")
public class InserirVendedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Funcionario vendedor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirVendedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		FuncionarioSession fs = new FuncionarioSession();
		vendedor = fs.getFuncionarioById(new Long(0).parseLong(request.getParameter("idVendedor")));
		request.getSession().setAttribute("vendedor", vendedor);
		
		String nextJSP = "/PrePedidoVendaServlet";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

}
