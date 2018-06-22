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
import br.com.vsetsistemas.services.ClienteWebServices;
import br.com.vsetsistemas.services.CondicaoPagamentoWebService;
import br.com.vsetsistemas.services.FuncionarioWebService;
import br.com.vsetsistemas.services.ProdutoWebService;
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.FuncionarioSession;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getSession().setAttribute("numeroPedido", pedidoVenda.getNumero());

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		request.getSession().setAttribute("dataPedido", format.format(pedidoVenda.getDataAbertura()));

		//ClienteSession cs = new ClienteSession();
		//List<Cliente> listaClientes = cs.listAll();
		ClienteWebServices cws = new ClienteWebServices();
		List<Cliente> listaClientes = cws.listarTodos();
		request.getSession().setAttribute("listaClientes", listaClientes);

		//FuncionarioSession fs = new FuncionarioSession();
		//List<Funcionario> listaVendedores = fs.listAll();
		FuncionarioWebService fws = new FuncionarioWebService();
		List<Funcionario> listaVendedores = fws.listarTodos();
		request.getSession().setAttribute("listaVendedores", listaVendedores);

		//CondicaoPagamentoSession cps = new CondicaoPagamentoSession();
		//List<CondicaoPagamento> listaCondPag = cps.listAll();
		CondicaoPagamentoWebService cpws = new CondicaoPagamentoWebService();
		List<CondicaoPagamento> listaCondPag = cpws.listarTodos();
		request.getSession().setAttribute("listaCondPag", listaCondPag);

		//ProdutoSession ps = new ProdutoSession();
		//List<Produto> listaProdutos = ps.listAll();
		ProdutoWebService pws = new ProdutoWebService();
		List<Produto> listaProdutos = pws.listarTodos();
		request.getSession().setAttribute("listaProdutos", listaProdutos);

		request.getSession().setAttribute("pedidoVenda", pedidoVenda);
		
		if (request.getParameter("vlrDesconto") != null) {
			
			pedidoVenda.setDesconto(Double.parseDouble(request.getParameter("vlrDesconto")));
			request.getSession().setAttribute("valorTotal", pedidoVenda.getValorSubtotal() - pedidoVenda.getDesconto());
			request.getSession().setAttribute("desconto", pedidoVenda.getDesconto());
		} else
			request.getSession().setAttribute("valorTotal", pedidoVenda.getValorTotal());

		String nextJSP = "/inserirPedidoVenda.jsp";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
