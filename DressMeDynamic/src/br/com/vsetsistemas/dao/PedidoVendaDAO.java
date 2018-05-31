package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;

public class PedidoVendaDAO extends DAO {

	/* DONE */private String SQL_INSERT = "INSERT INTO PedidoVenda (numero, orcamento, dataAbertura, dataFechamento, cliente, condPag, vendedor, situacao, valorTotal, valorSubtotal, desconto, numero_pontos, status) values(?, ?, (date(sysdate()), (date(sysdate())+interval '30' day) , ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	/* DONE */private String SQL_INSERT_PRODUCT = "INSERT INTO produto_pedidovenda (idpedido, idproduto, quantidade, desconto, subtotal, vunitario, iditem) values (?, ?, ?, ?, ?, ?, ?);";

	/* DONE */private String SQL_UPDATE = "UPDATE PedidoVenda SET dataFechamento=?, orcamento=?, cliente=?, condPag=?, vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=?, numero_pontos=?, status=? WHERE numero = ?;";

	/* DONE */private String SQL_UPDATE_PRODUCT = "UPDATE produto_pedidovenda SET quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE idpedido=?;";

	/* DONE */private String SQL_UPDATE_SINGLE_PRODUCT = "UPDATE produto_pedidovenda SET quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE (idpedido=? AND idproduto=? AND iditem=?);";

	/* DONE */private String SQL_DELETE = "UPDATE PedidoVenda SET status = false, situacao='Cancelado' WHERE numero = ?;";

	/* DONE */private String SQL_CANCEL = "UPDATE PedidoVenda SET status = false, situacao='Cancelado' WHERE numero = ?;";

	/* DONE */private String SQL_DELETE_PRODUCT = "DELETE FROM produto_pedidovenda WHERE (idpedido=? AND idproduto=? AND iditem=?);";

	/* DONE */private String SQL_SELECT = "select pv.numero, pv.orcamento, pv.dataAbertura, pv.dataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal,pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status from pedidovenda pv where pv.status = true;";

	/* DONE */private String SQL_SELECT_PRODUCT = "select * from produto_pedidovenda WHERE idpedido = ?;";

	/* DONE */private String SQL_OBTAIN = "select pv.numero, pv.orcamento, pv.DataAbertura, pv.DataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status FROM PedidoVenda pv WHERE pv.status = true AND pv.numero = ?;";

	/* DONE */private String SQL_OBTAIN_BY_ID = "select pv.numero, pv.orcamento, pv.DataAbertura, pv.DataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status FROM PedidoVenda pv WHERE pv.status = true AND pv.numero = ?;";

	/* DONE */private String SQL_OBTAIN_PRODUCT = "SELECT * FROM produto_pedidovenda WHERE (idpedido = ? AND idproduto = ? AND iditem = ?);";

	private String SQL_SEARCH = "select pv.numero, pv.orcamento, pv.dataAbertura, pv.dataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal,pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status from pedidovenda pv where (pv.numero = ? or pv.orcamento = ? or pv.dataAbertura = ? or pv.dataFechamento = ? or pv.cliente = ? or pv.condPag = ? or pv.vendedor = ? or pv.situacao = ? or pv.valorTotal = ? or pv.valorSubtotal = ? or pv.desconto = ? or pv.numero_pontos = ? or pv.status = ?);";

	private String SQL_INVOICE = "insert into contas_receber (id_cliente, valor_receber, data_lancamento, id_cond_pagamento) values (?,?,(date(sysdate())),?);";

	private String SQL_INVOICE_PEDIDO = "UPDATE PedidoVenda SET status = false, situacao='Faturado' WHERE numero = ?;";

	private String SQL_OBTAIN_LAST_REGISTER = "select count(numero)+1 ultimo from pedidovenda;";
	
	private String SQL_OBTAIN_SUM_VALUES = "SELECT SUM(VUNITARIO*QUANTIDADE) as total_geral, SUM(desconto) as total_desconto FROM produto_pedidovenda WHERE idpedido=?;";

	public void insert(PedidoVenda p) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);

			ps.setLong(1, p.getNumero());
			ps.setBoolean(2, p.isOrcamento());
			ps.setDate(3, p.getDataFechamento());
			ps.setLong(4, p.getCliente().getId());
			ps.setLong(5, p.getCondPagamento().getId());
			ps.setLong(6, p.getVendedor().getId());
			ps.setString(7, p.getSituacao());
			ps.setDouble(8, p.getValorTotal());
			ps.setDouble(9, p.getValorSubtotal());
			ps.setDouble(10, p.getDesconto());
			ps.setInt(11, p.getNumeroPontos());
			ps.setBoolean(12, p.isStatus());
			ps.executeUpdate();

			// INSERT INTO produto_pedidovenda (idpedido, idproduto, quantidade, desconto,
			// subtotal, vunitario, iditem) values (?, ?, ?, ?, ?, ?, ?);
			for (int i = 0; i < p.getListaProduto().size(); i++) {

				long iditem = i + 1;
				PreparedStatement ps2 = db.getConnection().prepareStatement(SQL_INSERT_PRODUCT);
				ps2.setLong(1, p.getListaProduto().get(i).getPedido().getNumero());
				ps2.setInt(2, p.getListaProduto().get(i).getProduto().getId());
				ps2.setInt(3, p.getListaProduto().get(i).getQuantidade());
				ps2.setDouble(4, p.getListaProduto().get(i).getDesconto());
				ps2.setDouble(5, p.getListaProduto().get(i).getSubtotal());
				ps2.setDouble(6, p.getListaProduto().get(i).getValorUnitario());
				ps2.setLong(7, iditem);

				ps2.executeUpdate();
			}

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Double[] insertProduct(Item i) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_PRODUCT);

			ps.setLong(1, i.getPedido().getNumero());
			ps.setLong(2, i.getProduto().getId());
			ps.setInt(3, i.getQuantidade());
			ps.setDouble(4, i.getDesconto());
			ps.setDouble(5, i.getSubtotal());
			ps.setDouble(6, i.getValorUnitario());
			ps.setLong(7, i.getId());

			ps.executeUpdate();
			
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.sumValues(i.getPedido().getNumero());
		
	}

	public void update(PedidoVenda p) {

		try {
			conectar();

			// UPDATE PedidoVenda SET dataFechamento=?, orcamento=?, cliente=?, condPag=?
			// , vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=?,
			// numero_pontos=?, status=? WHERE numero = ?;
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setDate(1, p.getDataFechamento());
			ps.setBoolean(2, p.isOrcamento());
			ps.setLong(3, p.getCliente().getId());
			ps.setInt(4, p.getCondPagamento().getId());
			ps.setLong(5, p.getVendedor().getId());
			ps.setString(6, p.getSituacao());
			ps.setDouble(7, p.getValorTotal());
			ps.setDouble(8, p.getValorSubtotal());
			ps.setDouble(9, p.getDesconto());
			ps.setInt(10, p.getNumeroPontos());
			ps.setBoolean(11, p.isStatus());
			ps.setLong(12, p.getNumero());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateProduct(Item i) {

		// UPDATE produto_pedidovenda SET quantidade=?, desconto=?, subtotal=?,
		// vunitario=? WHERE idpedido=?;

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_PRODUCT);

			ps.setInt(1, i.getQuantidade());
			ps.setDouble(2, i.getDesconto());
			ps.setDouble(3, i.getSubtotal());
			ps.setDouble(4, i.getValorUnitario());
			ps.setLong(5, i.getPedido().getNumero());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSingleProduct(Item i) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_SINGLE_PRODUCT);

			ps.setInt(1, i.getQuantidade());
			ps.setDouble(2, i.getDesconto());
			ps.setDouble(3, i.getSubtotal());
			ps.setDouble(4, i.getValorUnitario());

			ps.setLong(5, i.getPedido().getNumero());
			ps.setLong(6, i.getProduto().getId());
			ps.setLong(7, i.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(PedidoVenda p) {

		// UPDATE PedidoVenda SET status = false, situacao='Cancelado' WHERE numero = ?;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setLong(1, p.getNumero());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cancel(PedidoVenda p) {

		// UPDATE PedidoVenda SET status = false, situacao='Cancelado' WHERE numero = ?;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_CANCEL);

			ps.setLong(1, p.getNumero());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(Item i) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_PRODUCT);

			ps.setLong(1, i.getPedido().getNumero());
			ps.setLong(2, i.getProduto().getId());
			ps.setLong(3, i.getId());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<PedidoVenda> select() {

		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();

		List<PedidoVenda> l = new ArrayList<PedidoVenda>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cliente c = new Cliente();
				c.setId(rs.getLong("cliente"));
				c = cdao.obtain(c);

				Funcionario f = new Funcionario();
				f.setId(rs.getLong("vendedor"));
				f = fdao.obtain(f);

				CondicaoPagamento cp = new CondicaoPagamento();
				cp.setId(rs.getInt("condPag"));
				cp = cpdao.obtain(cp);

				PedidoVenda pv = new PedidoVenda(rs.getLong("numero"), rs.getBoolean("orcamento"),
						rs.getDate("dataabertura"), rs.getDate("datafechamento"), c, cp, f,
						selectProduct(rs.getLong("numero")), rs.getString("situacao"), rs.getDouble("valortotal"),
						rs.getDouble("valorsubtotal"), rs.getDouble("desconto"), rs.getBoolean("status"),
						rs.getInt("numero_pontos"));
				l.add(pv);
			}

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;

	}

	public List<Item> selectProduct(long idPedidoVenda) {

		List<Item> l = new ArrayList<Item>();

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_PRODUCT);
			ps.setLong(1, idPedidoVenda);
			// private String SQL_SELECT_PRODUCT = "select * from produto_pedidovenda WHERE
			// id = ?;";
			ResultSet rs = ps.executeQuery();

			PedidoVenda pv = new PedidoVenda();
			pv.setNumero(idPedidoVenda);

			while (rs.next()) {
				ProdutoDAO pdao = new ProdutoDAO();
				Produto p = null;
				p = pdao.obtainById(rs.getInt("idproduto"));
				Item i = new Item(rs.getLong("iditem"), p, rs.getInt("quantidade"), rs.getDouble("desconto"),
						rs.getDouble("subtotal"), rs.getDouble("vunitario"), pv);
				l.add(i);
			}
			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;

	}

	public PedidoVenda obtain(PedidoVenda p) {

		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();
		PedidoVenda rpv = null;

		try {

			conectar();
			// select pv.numero, pv.orcamento, pv.DataAbertura, pv.DataFechamento,
			// pv.cliente, pv.condPag, pv.vendedor,
			// pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto, pv.numero_pontos,
			// pv.status FROM PedidoVenda
			// pv WHERE pv.status = true AND pv.numero = ?;
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, p.getNumero());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cliente c = new Cliente();
				c = cdao.obtainById(rs.getLong("cliente"));

				Funcionario f = new Funcionario();
				f = fdao.obtainById(rs.getLong("vendedor"));

				CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("condPag"), "");
				cp.setDescricao(cpdao.obtain(cp).getDescricao());

				PedidoVenda pv = new PedidoVenda(rs.getLong("numero"), rs.getBoolean("orcamento"),
						rs.getDate("dataabertura"), rs.getDate("datafechamento"), c, cp, f,
						selectProduct(rs.getLong("numero")), rs.getString("situacao"), rs.getDouble("valortotal"),
						rs.getDouble("valorsubtotal"), rs.getDouble("desconto"), rs.getBoolean("status"),
						rs.getInt("numero_pontos"));

				if (pv != null)
					rpv = pv;
				break;
			}

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rpv;

	}

	public PedidoVenda obtainById(long id) {

		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();
		PedidoVenda rpv = null;

		try {

			conectar();
			// select pv.numero, pv.orcamento, pv.DataAbertura, pv.DataFechamento,
			// pv.cliente, pv.condPag, pv.vendedor,
			// pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto, pv.numero_pontos,
			// pv.status FROM PedidoVenda
			// pv WHERE pv.status = true AND pv.numero = ?;
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cliente c = new Cliente();
				c = cdao.obtainById(rs.getLong("cliente"));

				Funcionario f = new Funcionario();
				f = fdao.obtainById(rs.getLong("vendedor"));

				CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("condPag"), "");
				cp.setDescricao(cpdao.obtain(cp).getDescricao());

				PedidoVenda pv = new PedidoVenda(rs.getLong("numero"), rs.getBoolean("orcamento"),
						rs.getDate("dataabertura"), rs.getDate("datafechamento"), c, cp, f,
						selectProduct(rs.getLong("numero")), rs.getString("situacao"), rs.getDouble("valortotal"),
						rs.getDouble("valorsubtotal"), rs.getDouble("desconto"), rs.getBoolean("status"),
						rs.getInt("numero_pontos"));

				if (pv != null)
					rpv = pv;
				break;
			}

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rpv;

	}

	public Item obtainProduct(Item i) {

		ProdutoDAO pdao = new ProdutoDAO();
		Item ri = null;

		// SELECT * FROM produto_pedidovenda WHERE (idpedido = ? AND idproduto = ? AND
		// iditem = ?);

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_PRODUCT);
			ps.setLong(1, i.getPedido().getNumero());
			ps.setLong(2, i.getProduto().getId());
			ps.setLong(3, i.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Produto p = null;
				p = pdao.obtain(p);

				PedidoVenda pv = this.obtainById(i.getPedido().getNumero());

				Item i1 = new Item(rs.getLong("iditem"), p, rs.getInt("quantidade"), rs.getDouble("desconto"),
						rs.getDouble("subtotal"), rs.getDouble("vunitario"), pv);

				if (i1 != null) {
					ri = i1;
					break;
				}
			}
			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ri;
	}

	public List<PedidoVenda> search(PedidoVenda pv) {

		List<PedidoVenda> lista = new ArrayList<>();
		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();

		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SEARCH);

			/*
			 * select pv.numero, pv.orcamento, pv.dataAbertura, pv.dataFechamento,
			 * pv.cliente, pv.condPag, pv.vendedor, pv.situacao,
			 * pv.valorTotal,pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status from
			 * pedidovenda pv where (pv.numero = ? or pv.orcamento = ? or pv.dataAbertura =
			 * ? or pv.dataFechamento = ? or pv.cliente = ? or pv.condPag = ? or pv.vendedor
			 * = ? or pv.situacao = ? or pv.valorTotal = ? or pv.valorSubtotal = ? or
			 * pv.desconto = ? or pv.numero_pontos = ? or pv.status);
			 */
			ps.setLong(1, pv.getNumero());
			ps.setBoolean(2, pv.isOrcamento());
			ps.setDate(3, pv.getDataAbertura());
			ps.setDate(4, pv.getDataFechamento());
			if (pv.getCliente() != null)
				ps.setLong(5, pv.getCliente().getId());
			else
				ps.setLong(5, 0);
			if (pv.getCondPagamento() != null)
				ps.setInt(6, pv.getCondPagamento().getId());
			else {
				ps.setInt(6, 0);
			}
			if (pv.getVendedor() != null)
				ps.setLong(7, pv.getVendedor().getId());
			else
				ps.setLong(7, 0);
			ps.setString(8, pv.getSituacao());
			ps.setDouble(9, pv.getValorTotal());
			ps.setDouble(10, pv.getValorSubtotal());
			ps.setDouble(11, pv.getDesconto());
			ps.setInt(12, pv.getNumeroPontos());
			ps.setBoolean(13, pv.isStatus());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Cliente c = new Cliente();
				c = cdao.obtainById(rs.getLong("cliente"));

				Funcionario f = new Funcionario();
				f = fdao.obtainById(rs.getLong("vendedor"));

				CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("condPag"), "");
				cp.setDescricao(cpdao.obtain(cp).getDescricao());

				PedidoVenda p = new PedidoVenda();
				p.setNumero(rs.getLong("numero"));
				p.setOrcamento(rs.getBoolean("orcamento"));
				p.setDataAbertura(rs.getDate("dataAbertura"));
				p.setDataFechamento(rs.getDate("dataFechamento"));
				p.setCliente(c);
				p.setCondPagamento(cp);
				p.setVendedor(f);
				p.setSituacao(rs.getString("situacao"));
				p.setValorTotal(rs.getDouble("valorTotal"));
				p.setValorSubtotal(rs.getDouble("valorSubtotal"));
				p.setDesconto(rs.getDouble("desconto"));
				p.setNumeroPontos(rs.getInt("numero_pontos"));
				p.setStatus(rs.getBoolean("status"));

				lista.add(p);
			}

			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void invoice(PedidoVenda pv) {

		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INVOICE);

			// insert into contas_receber (id_cliente, valor_receber, data_lancamento,
			// id_cond_pagamento) values (?,?,(date(sysdate())),?);
			ps.setLong(1, pv.getCliente().getId());
			ps.setDouble(2, pv.getValorTotal());
			ps.setInt(3, pv.getCondPagamento().getId());
			ps.executeUpdate();

			// UPDATE PedidoVenda SET status = false, situacao='Faturado' WHERE numero = ?;
			PreparedStatement ps1 = db.getConnection().prepareStatement(SQL_INVOICE_PEDIDO);
			ps1.setLong(1, pv.getNumero());
			ps1.executeUpdate();

			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public long obtainLastRegister() {

		long i = 0;
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_LAST_REGISTER);
			ResultSet rs = ps.executeQuery();
			i = rs.getInt("ultimo");
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public Double[] sumValues(long idPedidoVenda) {
		
		Double[] sumValues = {0.00};
		try { 
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_SUM_VALUES);
			ps.setLong(1, idPedidoVenda);
			ResultSet rs = ps.executeQuery();
			//SELECT SUM(VUNITARIO*QUANTIDADE) as total_geral, SUM(desconto) as total_desconto FROM produto_pedidovenda WHERE idpedido=?;
			while(rs.next()) {
				sumValues[0] = rs.getDouble("total_geral");
				sumValues[1] = rs.getDouble("total_desconto");
				sumValues[2] = (rs.getDouble("total_geral")-rs.getDouble("total_desconto"));
			}
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sumValues;
	}

}