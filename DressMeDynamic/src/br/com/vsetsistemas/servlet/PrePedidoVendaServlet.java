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
import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.CondicaoPagamentoSession;
import br.com.vsetsistemas.session.FuncionarioSession;
import br.com.vsetsistemas.session.PedidoVendaSession;
import br.com.vsetsistemas.session.ProdutoSession;

/**
 * Servlet implementation class prePedidoVendaServlet
 */
@WebServlet("/PrePedidoVendaServlet")
public class PrePedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static PedidoVenda pedidoVenda;
       
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
		pedidoVenda = session.loadInitialParameters();
		request.getSession().setAttribute("numeroPedido", pedidoVenda.getNumero()+1);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		request.getSession().setAttribute("dataPedido", format.format(pedidoVenda.getDataAbertura()));
		
		ClienteSession cs = new ClienteSession();
		List<Cliente> listaClientes = cs.listAll();
		request.getSession().setAttribute("listaClientes", listaClientes);

		FuncionarioSession fs = new FuncionarioSession();
		List<Funcionario> listaVendedores = fs.listAll(); 
		request.getSession().setAttribute("listaVendedores", listaVendedores);
		
		CondicaoPagamentoSession cps = new CondicaoPagamentoSession();
		List<CondicaoPagamento> listaCondPag = cps.listAll();
		request.getSession().setAttribute("listaCondPag", listaCondPag);
		
		ProdutoSession ps = new ProdutoSession();
		List<Produto> listaProdutos = ps.listAll();
		request.getSession().setAttribute("listaProdutos", listaProdutos);
		
		request.getSession().setAttribute("pedidoVenda", pedidoVenda);
		
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
