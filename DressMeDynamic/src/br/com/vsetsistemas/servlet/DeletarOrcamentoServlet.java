package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import br.com.vsetsistemas.session.ClienteSession;
import br.com.vsetsistemas.session.CondicaoPagamentoSession;
import br.com.vsetsistemas.session.FuncionarioSession;
import br.com.vsetsistemas.session.PedidoVendaSession;

@WebServlet("/DeletarOrcamentoServlet")
public class DeletarOrcamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PedidoVendaSession pvs = new PedidoVendaSession();
		// Obter parametros do formulário
		String numero = request.getParameter("numero");
		String dataAbertura = request.getParameter("dataAbertura");
		String dataFechamento = request.getParameter("dataFechamento");
		String cliente = request.getParameter("cliente");
		String condPag = request.getParameter("condPag");
		String vendedor = request.getParameter("vendedor");
		String valorTotal = request.getParameter("valorTotal");
		String valorSubtotal = request.getParameter("valorSubtotal");
		String valorDesconto = request.getParameter("desconto");

		PedidoVenda pv = new PedidoVenda();
		pv.setNumero(new Long(0).parseLong(numero));
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		// pv.setDataAbertura(sf.parse(dataAbertura));
		// pv.setDataFechamento(dataFechamento);
		ClienteSession cs = new ClienteSession();
		Cliente c = cs.obtainByCpf(new Long(0).parseLong(cliente));
		pv.setCliente(c);
		CondicaoPagamentoSession cps = new CondicaoPagamentoSession();
		CondicaoPagamento cp = cps.obtainById(new Integer(0).parseInt(condPag));
		pv.setCondPagamento(cp);
		FuncionarioSession fs = new FuncionarioSession();
		Funcionario f = fs.getFuncionarioById(new Long(0).parseLong(vendedor));
		pv.setVendedor(f);
		pv.setValorTotal(new Double(0.0).parseDouble(valorTotal));
		pv.setValorSubtotal(new Double(0.0).parseDouble(valorSubtotal));
		pv.setDesconto(new Double(0.0).parseDouble(valorDesconto));
		pv.setListaProduto(pvs.listAllProduct(pv));
		pv.setSituacao("Realizado");
		pv.setStatus(true);

		pvs.deletePedidoVenda(pv);

		List<PedidoVenda> lista = pvs.listAllBudges();

		if (lista == null)
			lista = new ArrayList<PedidoVenda>();

		request.setAttribute("listaOrcamentos", lista);

		String nextJSP = "/orcamento/listarOrcamentos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}

}
