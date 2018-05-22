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
		/*
		
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
		
		*/
		
		//consultar pedido de venda
		PedidoVenda pv1 = null;
		PedidoVendaDAO pdao1 = new PedidoVendaDAO();
		pv1 = pdao1.obtainById(1);
		
		System.out.println("Numero: " + pv1.getNumero());
		System.out.println("Orçamento: "+pv1.isOrcamento());
		System.out.println("Data Abertura: "+pv1.getDataAbertura());
		System.out.println("Data fechamento: "+pv1.getDataFechamento());
		System.out.println("Cliente: "+pv1.getCliente().getId());
		System.out.println("Condição pagamento: "+pv1.getCondPagamento().getId());
		System.out.println("Vendedor: "+pv1.getVendedor().getId());
		System.out.println("Situacao: "+pv1.getSituacao());
		System.out.println("Valor total: "+pv1.getValorTotal());
		System.out.println("Valor subtotal: "+pv1.getValorSubtotal());
		System.out.println("Desconto: "+pv1.getDesconto());
		System.out.println("Numero pontos: "+pv1.getNumeroPontos());
		System.out.println("Status: "+pv1.isStatus());
		for (int i2 = 0; i2<pv1.getListaProduto().size();i2++) {
			System.out.println(pv1.getListaProduto().get(i2).getId());
		}
	}

}
