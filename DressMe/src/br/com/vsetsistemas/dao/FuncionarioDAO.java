package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.model.Funcionario;

public class FuncionarioDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO pessoa (id, cep, numero, complemento, email, nome, cidade, status) values (?, ?, ?, ?, ?, ?, ?, ?);";
	private String SQL_INSERT_2= "INSERT INTO funcionario (id, login, senha, cargo) values(?,?,?,?);";

	private String SQL_UPDATE = "UPDATE funcionario SET login=?, senha=?, cargo=? WHERE id = ?;";
	private String SQL_UPDATE_2 = "UPDATE pessoa SET cep=?, numero=?, complemento=?, email=?, nome=?, cidade=?, status=? WHERE id=?";

	private String SQL_DELETE = "UPDATE pessoa SET status = ? WHERE id = ?;";

	private String SQL_SELECT = "select f.id, f.login, f.senha, f.cargo,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade,p.status," + "l.ufe_sg, l.log_nome "
			+ "FROM Funcionario f INNER JOIN pessoa p ON (f.id = p.id)"
			+ " INNER JOIN log_logradouro l ON (p.cep = l.cep)" + " WHERE p.status = true;";

	private String SQL_OBTAIN = "select f.id, f.login, f.senha, f.cargo,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade,p.status, " + "l.ufe_sg, l.log_nome "
			+ "FROM Funcionario f INNER JOIN pessoa p ON (f.id = p.id)"
			+ " INNER JOIN log_logradouro l ON (p.cep = l.cep)" + " WHERE f.status = true AND f.id = ?;";

	private String SQL_OBTAIN_BY_EMAIL = "select f.id, f.login, f.senha, f.cargo,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade,p.status, " + "l.ufe_sg, l.log_nome "
			+ "FROM Funcionario f INNER JOIN pessoa p ON (f.id = p.id)"
			+ " INNER JOIN log_logradouro l ON (p.cep = l.cep)" + " WHERE p.status = true AND p.email = ?;";

	public void insert(Funcionario f) {

		try {
			conectar();
//(2,"Alisson de Oliveira Teixeira", 8057, "Apartamento", 83703335, "Curitiba", "ally@waifu.club", "Ally","ALICELOVESYOU", c, true);
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
		
			/*
			 * "INSERT INTO pessoa (id, cep, numero, complemento, email, nome, cidade, status) values (?, ?, ?, ?, ?, ?, ?, ?);"
			+ "INSERT INTO Funcionario (id, login, senha, cargo) values(?, ?, ?, ?);";
			 * */
			ps.setLong(1, f.getId());
			ps.setLong(2, f.getCep());
			ps.setInt(3, f.getNumero());
			ps.setString(4, f.getComplemento());
			ps.setString(5, f.getEmail());
			ps.setString(6, f.getNome());
			ps.setString(7, f.getCidade());
			ps.setBoolean(8, true);
			
			PreparedStatement ps2 = db.getConnection().prepareStatement(SQL_INSERT_2);
			ps2.setLong(1, f.getId());
			ps2.setString(2, f.getLogin());
			ps2.setString(3, f.getSenha());
			ps2.setLong(4, f.getCargo().getId());

			ps.executeUpdate();
			ps2.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Funcionario f) {

		try {
/*UPDATE funcionario SET login=?, senha=?, cargo=? WHERE id = ?;";
	private String SQL_UPDATE_2 = "UPDATE pessoa SET cep=?, numero=?, complemento=?, email=?, nome=?, cidade=?, status=? WHERE id=?";
 * */
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setString(1, f.getLogin());
			ps.setString(2, f.getSenha());
			ps.setLong(3, f.getCargo().getId());
			ps.setLong(4, f.getId());

			PreparedStatement ps2 = db.getConnection().prepareStatement(SQL_UPDATE_2);
			ps2.setLong(1, f.getCep());
			ps2.setInt(2, f.getNumero());
			ps2.setString(3, f.getComplemento());
			ps2.setString(4, f.getEmail());
			ps2.setString(5, f.getNome());
			ps2.setString(6, f.getCidade());
			ps2.setBoolean(7, f.isStatus());
			ps2.setLong(8, f.getId());

			ps.executeUpdate();
			ps2.executeUpdate();
			
			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void delete(Funcionario f) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setBoolean(1, f.isStatus());
			ps.setLong(2, f.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public List<Funcionario> select() {
		CargoDAO cdao = new CargoDAO();
		List<Funcionario> l = new ArrayList<Funcionario>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cargo c = new Cargo(rs.getInt("cargo"), "", true);
				c = cdao.obtain(c);

				Funcionario f = new Funcionario(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getString("login"), rs.getString("senha"), c, rs.getBoolean("status"));
				l.add(f);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Funcionario obtain(Funcionario f) {
		CargoDAO cdao = new CargoDAO();
		Funcionario fe = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, f.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cargo c = new Cargo(rs.getInt("cargo"), "", true);
				c = cdao.obtain(c);

				Funcionario f1 = new Funcionario(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getString("login"), rs.getString("senha"), c, rs.getBoolean("status"));

				if (f1 != null) {
					fe = f1;
				}

			}

			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

		return fe;
	}

	public Funcionario obtainByEmail(String e) {
		CargoDAO cdao = new CargoDAO();
		Funcionario fe = null;
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_EMAIL);
			ps.setString(1, e);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cargo c = new Cargo(rs.getInt("cargo"), "", true);
				c = cdao.obtain(c);

				Funcionario f1 = new Funcionario(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getString("login"), rs.getString("senha"),c,rs.getBoolean("status") );

				if (f1 != null) {
					fe = f1;
				}

			}
			desconectar();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return fe;
	}

}