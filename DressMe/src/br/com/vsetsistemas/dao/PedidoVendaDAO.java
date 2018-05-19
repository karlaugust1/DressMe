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

	/* DONE */private String SQL_INSERT = "INSERT INTO PedidoVenda (numero, orcamento, dataAbertura, dataFechamento, cliente, condPag, vendedor, situacao, valorTotal, valorSubtotal, desconto, numero_pontos, status) values(?, ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	/* DONE */private String SQL_INSERT_PRODUCT = "INSERT INTO produto_pedidovenda (idpedido, idproduto, quantidade, desconto, subtotal, vunitario, iditem) values (?, ?, ?, ?, ?, ?, ?);";

	/* DONE */private String SQL_UPDATE = "UPDATE PedidoVenda SET dataFechamento=?, orcamento=?, cliente=?, condPag=?, vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=?, numero_pontos=?, status=? WHERE numero = ?;";

	/* DONE */private String SQL_UPDATE_PRODUCT = "UPDATE produto_pedidovenda SET quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE idpedido=?;";

	/* DONE */private String SQL_UPDATE_SINGLE_PRODUCT = "UPDATE produto_pedidovenda SET quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE (idpedido=? AND idproduto=? AND iditem=?);";

	/* DONE */private String SQL_DELETE = "UPDATE PedidoVenda SET status = false, situacao='Cancelado' WHERE numero = ?;";

	/* DONE */private String SQL_DELETE_PRODUCT = "DELETE FROM produto_pedidovenda WHERE (idpedido=? AND idproduto=? AND iditem=?);";

	/* DONE */private String SQL_SELECT = "select pv.numero, pv.orcamento, pv.dataAbertura, pv.dataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal,pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status from pedidovenda pv where pv.status = true;";

	/* DONE */private String SQL_SELECT_PRODUCT = "select * from produto_pedidovenda WHERE id = ?;";

	/* DONE */private String SQL_OBTAIN = "select pv.numero, pv.orcamento, pv.DataAbertura, pv.DataFechamento, pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto, pv.numero_pontos, pv.status FROM PedidoVenda pv WHERE pv.status = true AND pv.numero = ?;";

	private String SQL_OBTAIN_PRODUCT = "SELECT * FROM produto_pedidovenda WHERE (idpedido = ? AND idproduto = ? AND iditem = ?);";

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

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertProduct(Item i) {

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
	}

	public void update(PedidoVenda p) {

		try {
			conectar();

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

	public Item obtainProduct(Item i) {

		Item ri = null;

		// SELECT * FROM produto_pedidovenda WHERE (idpedido = ? AND idproduto = ? AND iditem = ?);

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_PRODUCT);
			ps.setLong(1, i.getPedido().getNumero());
			ps.setLong(2, i.getProduto().getId());
			ps.setLong(3, i.getId());

			ResultSet rs = ps.executeQuery();

			// Produto p = new Produto(rs.getInt("idproduto"),0,"",true);
			// p=pdao.obtain(p);
			PedidoVenda pv = new PedidoVenda();
			pv = obtain(pv);

			while (rs.next()) {
				//Item i1 = new
				//Item(rs.getLong("iditem"),p,rs.getInt("quantidade"),rs.getDouble("desconto"),rs.getDouble("subtotal"),rs.getDouble("vunitario"),pv);
				//ri = i1;
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ri;
	}

}