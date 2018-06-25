package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Categoria;
import br.com.vsetsistemas.model.Fornecedor;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;

public class ProdutoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Produto (id, ean, descricao, status, nome, genero, tamanho, cor, vunitario) values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String SQL_INSERT_CATEGORIA = "INSERT INTO Categoria_Produto (id_categoria, id_produto) values (?, ?);";
	private String SQL_INSERT_FORNECEDOR = "INSERT INTO Fornecedor_Produto (id_fornecedor, id_produto) values (?, ?);";

	private String SQL_UPDATE = "UPDATE Produto SET ean = ?, descricao=?, status=?, nome=?, genero=?, tamanho=?, cor=?, vunitario=?, categoria=?, fornecedor=?, qtd_estoque = ? WHERE id = ?;";

	private String SQL_DELETE = "UPDATE produto SET status = ? WHERE id = ?;";

	private String SQL_SELECT = "select * from produto WHERE status = true;";

	private String SQL_OBTAIN = "select * from produto WHERE status = true AND id = ?;";
	private String SQL_OBTAIN_BY_ID = "SELECT * FROM produto WHERE status = true AND id = ?;";

	

	public void insert(Produto p) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setLong(1, p.getId());
			ps.setString(2, p.getDescricao());
			ps.setBoolean(3, p.isStatus());
			ps.setString(4, p.getNome());
			ps.setString(5, p.getGenero());
			ps.setString(6, p.getTamanho());
			ps.setString(7, p.getCor());
			ps.setDouble(8, p.getPreco());

			PreparedStatement newPs = db.getConnection().prepareStatement(SQL_INSERT_CATEGORIA);
			newPs.setLong(1, p.getCategoria().getId());
			newPs.setLong(2, p.getId());

			PreparedStatement newPs2 = db.getConnection().prepareStatement(SQL_INSERT_FORNECEDOR);
			newPs2.setLong(1, p.getFornecedor().getId());
			newPs2.setLong(2, p.getId());

			ps.executeUpdate();
			newPs.executeUpdate();
			newPs2.executeUpdate();

			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Produto p) {

		try {

			conectar();
			// UPDATE Produto SET ean = ?, descricao=?, status=?, nome=?, genero=?,
			// tamanho=?, cor=?, vunitario=?, categoria=?, fornecedor=?, qtd_estoque = ?
			// WHERE id = ?
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			ps.setLong(1, p.getEan());
			ps.setString(2, p.getDescricao());
			ps.setBoolean(3, p.isStatus());
			ps.setString(4, p.getNome());
			ps.setString(5, p.getGenero());
			ps.setString(6, p.getTamanho());
			ps.setString(7, p.getCor());
			ps.setDouble(8, p.getPreco());
			ps.setLong(9, p.getCategoria().getId());
			ps.setLong(10, p.getFornecedor().getId());
			ps.setInt(11, p.getQuantidadeEstoque());
			ps.setInt(12, p.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Produto p) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setBoolean(1, p.isStatus());
			ps.setLong(2, p.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Produto> select() {

		List<Produto> l = new ArrayList<Produto>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			/*
			 * long id, long ean, String descricao, boolean status, String nome, String
			 * genero, String tamanho, String cor, double preco, Categoria categoria,
			 * Fornecedor fornecedor
			 */

			// falar com ally sobre categoria e fornecedor (como fazer se for assim ou
			// mudar);
			while (rs.next()) {
				Produto p = new Produto(rs.getInt("id"), rs.getLong("ean"), rs.getString("descricao"),
						rs.getBoolean("status"), rs.getString("nome"), rs.getString("genero"), rs.getString("tamanho"),
						rs.getString("cor"), rs.getDouble("vunitario"), rs.getInt("qtd_estoque"), new Categoria(),
						new Fornecedor());
				l.add(p);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Produto obtain(Produto p) {
		Produto rp = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, p.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rp = new Produto(rs.getInt("id"), rs.getLong("ean"), rs.getString("descricao"), rs.getBoolean("status"),
						rs.getString("nome"), rs.getString("genero"), rs.getString("tamanho"), rs.getString("cor"),
						rs.getDouble("vunitario"), rs.getInt("qtd_estoque"), new Categoria(), new Fornecedor());
				break;
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rp;
	}

	public Produto obtainById(long id) {

		Produto p = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			// Item i = new Item(1, pdao.obtainById(1), 1, 0, 99.99, 99.99, pv);
			// SELECT * FROM produto WHERE status = true AND id = ?;
			CategoriaDAO cdao = new CategoriaDAO();
			Categoria c = null;
			// cdao.obtainById(rs.getLong("categoria"));

			FornecedorDAO fdao = new FornecedorDAO();
			Fornecedor f = null;
			// fdao.obtainById(rs.getLong("fornecedor"));

			while (rs.next()) {
				Produto newP = new Produto(rs.getInt("id"), rs.getLong("ean"), rs.getString("descricao"),
						rs.getBoolean("status"), rs.getString("nome"), rs.getString("genero"), rs.getString("tamanho"),
						rs.getString("cor"), rs.getDouble("vunitario"), rs.getInt("qtd_estoque"),
						(c = cdao.obtainById(rs.getLong("categoria"))), (fdao.obtainById(rs.getLong("fornecedor"))));
				if (newP != null) {
					p = newP;
					break;
				}
			}
			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}