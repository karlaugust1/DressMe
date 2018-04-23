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

	private String SQL_INSERT = "INSERT INTO PedidoVenda (numero, orcamento, dataAbertura, dataFechamento, cliente, condPag, vendedor, situacao, valorTotal, valorSubtotal, desconto) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private String SQL_INSERT_Product = "INSERT INTO produto_pedidovenda (idpedido, idproduto, quantidade, desconto, subtotal, vunitario) values (?, ?, ?, ?, ?, ?);";

	private String SQL_UPDATE = "UPDATE PedidoVenda SET DataFechamento=?, orcamento=?, cliente=?, condPag=?, vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=? WHERE numero = ?;";

	private String SQL_UPDATE_Product = "UPDATE produto_pedidovenda SET idproduto=?, quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE idpedido=?";

	private String SQL_UPDATE_Single_Product = "UPDATE produto_pedidovenda SET idproduto=?, quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE idpedido=? AND idproduto=?";

	private String SQL_DELETE = "UPDATE PedidoVenda SET status = ? WHERE numero = ?;";

	private String SQL_DELETE_PRODUCT = "DELETE FROM produto_pedidovenda WHERE idpedido=? AND idproduto=?";

	private String SQL_SELECT = "select pv.numero, pv.DataAbertura,pv.DataFechamento, pv.reservaEstoque,"
			+ "pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto,"
			+ "pp.idproduto, pp.quantidade, pp.desconto, pp.subtotal, pp.vunitario"
			+ "FROM PedidoVenda pv INNER JOIN produto_pedidovenda pp ON (pv.numero = pp.idpedido)"
			+ " WHERE pv.situacao = true;";

	private String SQL_SELECT_Product = "select * from produto_pedidovenda WHERE idorcamento = ?;";

	private String SQL_OBTAIN = "select pv.numero, pv.DataAbertura,pv.DataFechamento, pv.reservaEstoque,"
			+ "pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto,"
			+ "pp.idproduto, pp.quantidade, pp.desconto, pp.subtotal, pp.vunitario\"\r\n"
			+ "FROM PedidoVenda pv INNER JOIN produto_pedidovenda pp ON (pv.numero = pp.idpedido)"
			+ " WHERE pv.situacao = true AND pv.id = ?;";

	private String SQL_OBTAIN_Product = "select * from produto_pedidovenda WHERE idpedido = ? AND idproduto = ?;";

	public void insert(PedidoVenda p) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);

			ps.setLong(1, p.getNumero());
			ps.setBoolean(2, p.isOrcamento());
			ps.setDate(3, p.getDataAbertura());
			ps.setDate(4, p.getDataFechamento());

			ps.setLong(5, p.getCliente().getId());
			ps.setLong(6, p.getCondPagamento().getId());
			ps.setLong(7, p.getVendedor().getId());
			ps.setString(8, p.getSituacao());
			ps.setDouble(9, p.getValorTotal());
			ps.setDouble(10, p.getValorSubtotal());
			ps.setDouble(11, p.getDesconto());
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

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_Product);

			ps.setLong(1, i.getPedido().getNumero());
			//ps.setLong(2, i.getProduto().getId());
			ps.setInt(3, i.getQuantidade());
			ps.setDouble(4, i.getDesconto());
			ps.setDouble(5, i.getSubtotal());
			ps.setDouble(6, i.getValorUnitario());

			ps.executeUpdate();

			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(PedidoVenda p) {

		// UPDATE PedidoVenda SET DataFechamento=?, orcamento=?, cliente=?, condPag=?,
		// vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=? WHERE
		// numero = ?;"

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setDate(1, p.getDataFechamento());
			ps.setBoolean(2, p.isOrcamento());
			ps.setLong(3, p.getCliente().getId());
			ps.setLong(4, p.getVendedor().getId());
			ps.setString(5, p.getSituacao());
			ps.setDouble(6, p.getValorTotal());
			ps.setDouble(7, p.getValorSubtotal());
			ps.setDouble(8, p.getDesconto());

			ps.setLong(9, p.getNumero());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateProduct(Item i) {

		// "UPDATE produto_pedidovenda SET idproduto=?, quantidade=?, desconto=?,
		// subtotal=?, vunitario=? WHERE idpedido=?"

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_Product);

			//ps.setLong(1, i.getProduto().getId());
			ps.setInt(2, i.getQuantidade());
			ps.setDouble(3, i.getDesconto());
			ps.setDouble(4, i.getSubtotal());
			ps.setDouble(5, i.getValorUnitario());

			ps.setLong(6, i.getPedido().getNumero());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSingleProduct(Item i) {

		// "UPDATE produto_pedidovenda SET idproduto=?, quantidade=?, desconto=?,
		// subtotal=?, vunitario=? WHERE idpedido=? AND idproduto=?"

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_Single_Product);

			//ps.setInt(1, i.getProduto().getId());
			ps.setInt(2, i.getQuantidade());
			ps.setDouble(3, i.getDesconto());
			ps.setDouble(4, i.getSubtotal());
			ps.setDouble(5, i.getValorUnitario());

			ps.setLong(6, i.getPedido().getNumero());
			//ps.setLong(7, i.getProduto().getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(PedidoVenda p) {

		// "UPDATE PedidoVenda SET status = ? WHERE numero = ?;"

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setString(1, p.getSituacao());
			ps.setLong(2, p.getNumero());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(Item i) {

		// "DELETE FROM produto_pedidovenda WHERE idpedido=? AND idproduto=?"

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_PRODUCT);

			ps.setLong(1, i.getPedido().getNumero());
			//ps.setInt(2, i.getProduto().getId());

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
		
		/*
		 * "select pv.numero, pv.DataAbertura,pv.DataFechamento, pv.reservaEstoque," +
		 * "pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto,"
		 * + "pp.idproduto, pp.quantidade, pp.desconto, pp.subtotal, pp.vunitario" +
		 * "FROM PedidoVenda pv INNER JOIN produto_pedidovenda pp ON (pv.numero = pp.idpedido)"
		 * + " WHERE pv.situacao = true;"
		 */
		
		try {
		
			
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			
			Cliente c = new Cliente();
			c.setId(rs.getLong("cliente"));
			c = cdao.obtain(c);
			
			Funcionario f = new Funcionario();
			f.setId(rs.getLong("vendedor"));
			f = fdao.obtain(f);
			
			CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("id"),"");
			cp = cpdao.obtain(cp);
			
			while (rs.next()) {
				
				PedidoVenda pv = new PedidoVenda(rs.getLong("numero"),rs.getBoolean("orcamento"),rs.getDate("dataabertura"),
						rs.getDate("datafechamento"),c,cp,f,selectProduct(),rs.getString("status"),rs.getDouble("valortotal"),rs.getDouble("valorsubtotal"),rs.getDouble("desconto"));
				l.add(pv);
			}
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;

	}

	public List<Item> selectProduct() {

		List<Item> l = new ArrayList<Item>();
		ProdutoDAO pdao = new ProdutoDAO();
		
		//select * from produto_pedidovenda WHERE idorcamento = ?;
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_Product);
			ResultSet rs = ps.executeQuery();
			
			//Produto p = new Produto(rs.getInt("idproduto"),0,"",true);
			//p=pdao.obtain(p);
			PedidoVenda pv = new PedidoVenda();
			pv = obtain(pv);
			
			
			while (rs.next()) {
			//	Item i = new Item(rs.getLong("iditem"),p,rs.getInt("quantidade"),rs.getDouble("desconto"),rs.getDouble("subtotal"),rs.getDouble("vunitario"),pv);
			//	l.add(i);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return l;
		
	}

	public PedidoVenda obtain(PedidoVenda p) {

		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		CondicaoPagamentoDAO cpdao = new CondicaoPagamentoDAO();
		
		PedidoVenda rpv = null;
		
		/*"select pv.numero, pv.DataAbertura,pv.DataFechamento, pv.reservaEstoque,"
			+ "pv.cliente, pv.condPag, pv.vendedor, pv.situacao, pv.valorTotal, pv.valorSubtotal, pv.desconto,"
			+ "pp.idproduto, pp.quantidade, pp.desconto, pp.subtotal, pp.vunitario\"\r\n"
			+ "FROM PedidoVenda pv INNER JOIN produto_pedidovenda pp ON (pv.numero = pp.idpedido)"
			+ " WHERE pv.situacao = true AND pv.id = ?;"*/
		
		
		try {
		
			
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, p.getNumero());
			ResultSet rs = ps.executeQuery();
			
			Cliente c = new Cliente();
			c.setId(rs.getLong("cliente"));
			c = cdao.obtain(c);
			
			Funcionario f = new Funcionario();
			f.setId(rs.getLong("vendedor"));
			f = fdao.obtain(f);
			
			CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("id"),"");
			cp = cpdao.obtain(cp);
			
			while (rs.next()) {
				
				PedidoVenda pv = new PedidoVenda(rs.getLong("numero"),rs.getBoolean("orcamento"),rs.getDate("dataabertura"),
						rs.getDate("datafechamento"),c,cp,f,selectProduct(),rs.getString("status"),rs.getDouble("valortotal"),rs.getDouble("valorsubtotal"),rs.getDouble("desconto"));
				rpv = pv;
				break;
			}
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rpv;
		
	}

	public Item obtainProduct(Item i) {

		Item ri = null;
		
ProdutoDAO pdao = new ProdutoDAO();
		
		//"select * from produto_pedidovenda WHERE idpedido = ? AND idproduto = ?;"
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_Product);
			//ps.setLong(1, i.getPedido().getNumero());
			//ps.setInt(2, i.getProduto().getId());
			
			ResultSet rs = ps.executeQuery();
			
			
			//Produto p = new Produto(rs.getInt("idproduto"),0,"",true);
			//p=pdao.obtain(p);
			PedidoVenda pv = new PedidoVenda();
			pv = obtain(pv);
			
			
			while (rs.next()) {
				//Item i1 = new Item(rs.getLong("iditem"),p,rs.getInt("quantidade"),rs.getDouble("desconto"),rs.getDouble("subtotal"),rs.getDouble("vunitario"),pv);
			//	ri = i1;
				break;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ri;
	}

}