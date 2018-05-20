package br.com.vsetsistemas.app;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.ClienteDAO;
import br.com.vsetsistemas.dao.CondicaoPagamentoDAO;
import br.com.vsetsistemas.dao.FuncionarioDAO;
import br.com.vsetsistemas.dao.PedidoVendaDAO;
import br.com.vsetsistemas.dao.ProdutoDAO;
import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;


public class PediddoVendaApp {

	public static void main(String[] args) {
		
		//INSERT INTO PedidoVenda (numero, orcamento, dataAbertura, dataFechamento, cliente, condPag, vendedor, situacao
		//, valorTotal, valorSubtotal, desconto, numero_pontos, status) values(?, ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.obtainById(3);
		
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();
		CondicaoPagamento cp = cpdao.obtainById(1);
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f = fdao.obtainById(2);
		
		PedidoVendaSession pvs = new PedidoVendaSession();
		
		PedidoVenda pv = new PedidoVenda(1, false, null, null, c, cp, f, null,"Realizado", 263.98, 260.00, 3.98, true, pvs.converterEmPontos(260.00));
		
		ProdutoDAO pdao = new ProdutoDAO();
				
		List<Item> listaProduto = new ArrayList<>();
		Item i = new Item(1, pdao.obtainById(1), 1, 0, 99.99, 99.99, pv);
		Item i1 = new Item(2, pdao.obtainById(2), 1, 0, 163.99, 163.99, pv);
		listaProduto.add(i);
		listaProduto.add(i1);
		
		pv.setListaProduto(listaProduto);
		
		PedidoVendaDAO pvdao = new PedidoVendaDAO();
		pvdao.insert(pv);
	}

}
