package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Categoria;

public class CategoriaDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Categoria (id, descricao) values (?, ?);";

	private String SQL_OBTAIN = "SELECT * FROM Categoria WHERE id = ?";

	private String SQL_SELECT = "SELECT * FROM Categoria;";

	public List<Categoria> select() {

		List<Categoria> list = new ArrayList<>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria c = new Categoria(rs.getInt("id"), rs.getString("descricao"));
				list.add(c);

			}

			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public Categoria obtain(Categoria c) {

		Categoria retC = new Categoria();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, c.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				retC.setId(rs.getInt("id"));
				retC.setDescricao(rs.getString("descricao"));
				break;
			}

			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retC;
	}

	public Categoria obtainById(int id) {

		Categoria retC = new Categoria();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				retC.setId(rs.getInt("id"));
				retC.setDescricao(rs.getString("descricao"));
				break;
			}

			desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retC;
	}

}
