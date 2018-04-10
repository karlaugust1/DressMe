package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;

import br.com.vsetsistemas.model.Orcamento;

public class OrcamentoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Orcamento (numero, DataAbertura, DataFechamento, reservaEstoque, cliente, condPag, vendedor, situacao, valorTotal, valorSubtotal, desconto, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
			+ "INSERT INTO produto_orcamento (idorcamento, idproduto, quantidade, desconto, subtotal, vunitario) values (?, ?, ?, ?, ?, ?);";

	private String SQL_UPDATE = "UPDATE Orcamento SET DataFechamento=?, reservaEstoque=?, cliente=?, condPag=?, vendedor=?, situacao=?, valorTotal=?, valorSubtotal=?, desconto=?, status=? WHERE numero = ?;"
			+ "UPDATE produto_orcamento SET idproduto=?, quantidade=?, desconto=?, subtotal=?, vunitario=? WHERE idorcamento=?";

	private String SQL_DELETE = "UPDATE Orcamento SET status = ? WHERE numero = ?;";

	private String SQL_DELETE_PRODUCT = "DELETE FROM produto_orcamento WHERE idorcamento=? AND idproduto=?";

	private String SQL_SELECT = "select o.numero, o.DataAbertura, o.DataFechamento, o.reservaEstoque,"
			+ "o.cliente, o.condPag, o.vendedor, o.situacao, o.valorTotal, o.valorSubtotal, o.desconto, o.status "
			+ "op.idproduto, op.quantidade, op.desconto, op.subtotal, op.vunitario"
			+ "FROM Orcamento o INNER JOIN produto_orcamento op ON (o.numeri = op.idorcamento)"
			+ " WHERE o.status = true;";

	private String SQL_SELECT_Product = "select * from produto_orcamento WHERE idorcamento = ?;";

	private String SQL_OBTAIN = "select o.numero, o.DataAbertura, o.DataFechamento, o.reservaEstoque,\"\r\n"
			+ "			+ \"o.cliente, o.condPag, o.vendedor, o.situacao, o.valorTotal, o.valorSubtotal, o.desconto, o.status \" +\r\n"
			+ "			\"op.idproduto, op.quantidade, op.desconto, op.subtotal, op.vunitario\"\r\n"
			+ "			+ \"FROM Orcamento o INNER JOIN produto_orcamento op ON (o.numeri = op.idorcamento)\"\r\n"
			+ "			+ \" WHERE o.status = true AND o.id = ?;";

	private String SQL_OBTAIN_Product = "select * from produto_orcamento WHERE idorcamento = ? AND idproduto = ?;";

	public void insert(Orcamento o) {
		
		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setLong(1, o.getNumero());
			ps.setDate(2, o.getDataAbertura());
			ps.setDate(3, o.getDataFechamento());
			ps.setBoolean(4, o.isReservaEstoque());
			ps.setLong(5, o.getCliente().getId());
			ps.setLong(6, o.getCondPagamento().getId());
			ps.setLong(7,  o.getVendedor().getId());
			ps.setBoolean(8, o.isStatus());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}