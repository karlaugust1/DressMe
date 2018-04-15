package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;

import br.com.vsetsistemas.model.PedidoVenda;

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
			ps.setLong(7,  p.getVendedor().getId());
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

}