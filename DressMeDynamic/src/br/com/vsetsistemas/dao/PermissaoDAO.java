package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Permissao;

public class PermissaoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Permissao (id, descricao) values(?, ?);";

	private String SQL_UPDATE = "UPDATE Permissao SET descricao=? WHERE id = ?;";

	private String SQL_DELETE = "DELETE FROM permissao WHERE id = ?;";

	private String SQL_SELECT = "select * from permissao;";

	private String SQL_OBTAIN = "select * from permissao WHERE id = ?;";

	public void insert(Permissao p) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getDescricao());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Permissao p) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setString(1, p.getDescricao());
			ps.setInt(2, p.getId());
			

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Permissao p) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setInt(1, p.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Permissao> select() {

		List<Permissao> l = new ArrayList<Permissao>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Permissao p = new Permissao(rs.getInt("id"), rs.getString("descricao"));
				l.add(p);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Permissao obtain(Permissao p) {
		Permissao rp = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rp = new Permissao(rs.getInt("id"), rs.getString("descricao"));
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