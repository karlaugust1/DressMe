package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.CondicaoPagamentoSession;
import br.com.vsetsistemas.session.FuncionarioSession;
import br.com.vsetsistemas.session.PedidoVendaSession;
import br.com.vsetsistemas.session.ProdutoSession;

/**
 * Servlet implementation class EditarPedidoVendaServlet
 */
@WebServlet("/EditarPedidoVendaServlet")
public class EditarPedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static PedidoVenda pv;
	private double vlrDesconto = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarPedidoVendaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrou no get");

		/* Lógica da utilização dos pontos here */
		if (request.getParameter("utilizarPontos") != null)
		if (request.getParameter("utilizarPontos").equals("false")) {
			request.getSession().setAttribute("utilizar", "");
			pv.setDesconto(pv.getDesconto() - vlrDesconto);
			vlrDesconto = 0;
			pv.setValorTotal(pv.getValorSubtotal() - pv.getDesconto());

		}
		if (request.getParameter("utilizarPontos") != null) {
			if (request.getParameter("utilizarPontos").equals("true")) {
				System.out.println("Entrou no true");

				if (pv.getCliente() != null && pv.getValorSubtotal() != 0) {

					ClienteSession csession = new ClienteSession();
					Cliente c = csession.obtainById(pv.getCliente().getId());
					float porcentagemDesconto = (c.getQtdPontos() / 100);
					if (porcentagemDesconto > 0) {
						vlrDesconto = (pv.getValorSubtotal() * porcentagemDesconto);
						vlrDesconto = vlrDesconto / 100;
						pv.setDesconto(pv.getDesconto() + vlrDesconto);
						pv.setValorTotal(pv.getValorSubtotal() - pv.getDesconto());
						request.getSession().setAttribute("utilizar", "utilizar");
					}

				}
			}

		} else if (vlrDesconto != 0) {
			pv.setDesconto(pv.getDesconto() - vlrDesconto);
			vlrDesconto = 0;
			ClienteSession csession = new ClienteSession();
			Cliente c = csession.obtainById(pv.getCliente().getId());
			float porcentagemDesconto = (c.getQtdPontos() / 100);
			if (porcentagemDesconto > 0) {
				vlrDesconto = (pv.getValorSubtotal() * porcentagemDesconto);
				vlrDesconto = vlrDesconto / 100;
				pv.setDesconto(pv.getDesconto() + vlrDesconto);
				pv.setValorTotal(pv.getValorSubtotal() - pv.getDesconto());
			}

		}

		request.getSession().setAttribute("pedidoVenda", pv);
		String nextJSP = "/editarPedidoVenda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PedidoVendaSession session = new PedidoVendaSession();
		if (pv.getNumero() == 0)
			pv = session.obtainById(Long.parseLong(request.getParameter("numero")));

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

		/* Ações de alterar cliente, cond pagamento, vendedor e produtos here */
		int acao = 0;
		if (request.getParameter("acao") != null)
			acao = Integer.parseInt(request.getParameter("acao"));
		if (acao == 1) {
			Cliente c = cs.obtainById(Long.parseLong(request.getParameter("idCliente")));
			pv.setCliente(c);
		} else if (acao == 2) {
			Funcionario f = fs.getFuncionarioById(Long.parseLong(request.getParameter("idVendedor")));
			pv.setVendedor(f);
		} else if (acao == 3) {
			CondicaoPagamento cp = cps.obtainById(Integer.parseInt(request.getParameter("idCP")));
			pv.setCondPagamento(cp);
		} else if (acao == 4) {

			Item i = new Item();

			i.setProduto(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))));
			i.setQuantidade(Integer.parseInt(request.getParameter("qtdProduto")));// implementação do código de
																					// getParameter
			i.setId(pv.getListaProduto().size() + 1);
			i.setValorUnitario(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))).getPreco());
			i.setSubtotal(ps.obtainById(Integer.parseInt(request.getParameter("idProduto"))).getPreco()
					* Integer.parseInt(request.getParameter("qtdProduto")));

			pv.getListaProduto().add(i);

			Double subTotal = 0.0;

			for (Item item : pv.getListaProduto()) {
				subTotal += item.getProduto().getPreco() * item.getQuantidade();
			}
			pv.setValorSubtotal(subTotal);
			pv.setValorTotal(subTotal - pv.getDesconto());
		} else if (acao == 5) {

			long idItem = Long.parseLong(request.getParameter("idProduto"));

			for (Item i : pv.getListaProduto()) {
				if (i.getId() == idItem) {
					pv.getListaProduto().remove(i);
					break;
				}
			}

			Double subTotal = 0.0;

			for (Item item : pv.getListaProduto()) {
				subTotal += item.getProduto().getPreco() * item.getQuantidade();
			}

			pv.setValorSubtotal(subTotal);
			pv.setValorTotal(subTotal - pv.getDesconto());
		} else if (acao == 6) {

			if (request.getParameter("vlrDesconto") != null && !request.getParameter("vlrDesconto").isEmpty()) {
				pv.setDesconto(Double.parseDouble(request.getParameter("vlrDesconto")));
				pv.setValorTotal(pv.getValorSubtotal() - pv.getDesconto());

			} else
				request.getSession().setAttribute("valorTotal", pv.getValorTotal());
		}

		if (vlrDesconto != 0) {
			pv.setDesconto(pv.getDesconto() - vlrDesconto);
			vlrDesconto = 0;
			ClienteSession csession = new ClienteSession();
			Cliente c = csession.obtainById(pv.getCliente().getId());
			float porcentagemDesconto = (c.getQtdPontos() / 100);
			if (porcentagemDesconto > 0) {
				vlrDesconto = (pv.getValorSubtotal() * porcentagemDesconto);
				vlrDesconto = vlrDesconto / 100;
				pv.setDesconto(pv.getDesconto() + vlrDesconto);
				pv.setValorTotal(pv.getValorSubtotal() - pv.getDesconto());
			}
		}

		request.getSession().setAttribute("pedidoVenda", pv);

		String nextJSP = "/editarPedidoVenda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

}
