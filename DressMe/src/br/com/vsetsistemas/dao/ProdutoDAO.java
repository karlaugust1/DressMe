package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Produto;

public class ProdutoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Produto (id, descricao, ean, status) values(?, ?, ?, ?);";

	private String SQL_UPDATE = "UPDATE Produto SET ean=?, descricao=?, status=? WHERE id = ?;";

	private String SQL_DELETE = "UPDATE produto SET status = ? WHERE id = ?;";

	private String SQL_SELECT = "select * from produto WHERE status = true;";

	private String SQL_OBTAIN = "select * from produto WHERE status = true AND id = ?;";

	/*public void insert(Produto p) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getDescricao());
			ps.setLong(3, p.getEan());
			ps.setBoolean(3, p.isStatus());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
*/
	public void update(Produto p) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setString(2, p.getDescricao());
			ps.setLong(1, p.getEAN());
			ps.setBoolean(3, p.isStatus());
			ps.setInt(4, p.getId());
			;

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
			ps.setInt(2, p.getId());

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

			while (rs.next()) {
				Produto p = new Produto(rs.getInt("id"), rs.getLong("EAN"), rs.getString("descricao"), rs.getBoolean("status"));
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
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rp = new Produto(rs.getInt("id"), rs.getLong("EAN"), rs.getString("descricao"), rs.getBoolean("status"));
				break;
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rp;
	}

}