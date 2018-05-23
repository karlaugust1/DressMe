package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Cargo;

public class CargoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO cargo (id, descricao, status) values(?, ?, ?);";

	private String SQL_UPDATE = "UPDATE cargo SET descricao=?, status=? WHERE id = ?;";

	private String SQL_DELETE = "UPDATE cargo set status = ? WHERE id = ?;";

	private String SQL_SELECT = "select * from cargo WHERE status = true;";

	private String SQL_OBTAIN = "select * from cargo WHERE status = true AND id = ?;";

	public void insert(Cargo c) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setLong(1, c.getId());
			ps.setString(2, c.getDescricao());
			ps.setBoolean(3, c.isStatus());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Cargo c) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setString(1, c.getDescricao());
			ps.setBoolean(2, c.isStatus());
			ps.setLong(3, c.getId());
			;

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Cargo c) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setBoolean(1, c.isStatus());
			ps.setLong(2, c.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Cargo> select() {

		List<Cargo> l = new ArrayList<Cargo>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cargo c = new Cargo(rs.getInt("id"), rs.getString("descricao"), rs.getBoolean("status"));
				if (c.isStatus() != false)
					l.add(c);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Cargo obtain(Cargo c) {
		Cargo rc = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, c.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rc = new Cargo(rs.getInt("id"), rs.getString("descricao"), rs.getBoolean("status"));
				break;
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rc;
	}

	public Cargo obtainById(long id) {
		
		Cargo rc = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rc = new Cargo(rs.getInt("id"), rs.getString("descricao"), rs.getBoolean("status"));
				break;
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rc;
	}

}