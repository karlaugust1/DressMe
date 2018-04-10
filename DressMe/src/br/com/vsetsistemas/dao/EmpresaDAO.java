package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Empresa;

public class EmpresaDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO Empresa (id, cnpj, razao_social, inscricao_estadual) values(?, ?, ?, ?);"
			+ "INSERT INTO pessoa (id, cep, numero, complemento, email, nome, cidade, status) values (?, ?, ?, ?, ?, ?, ?, ?);";

	private String SQL_UPDATE = "UPDATE cliente SET cnpj=?, razao_social=?, inscricao_estadual=? WHERE id = ?;"
			+ "UPDATE pessoa SET cep=?, numero=?, complemento=?, email=?, nome=?, cidade=?, status=? WHERE id=?";

	private String SQL_DELETE = "UPDATE pessoa SET status = ? WHERE id = ?;";

	private String SQL_SELECT = "select e.id, e.cnpj, e.inscricao_estadual, e.razao_social,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade, " + "l.ufe_sg, l.log_nome "
			+ "FROM Empresa e INNER JOIN pessoa p ON (e.id = p.id)" + " INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ " WHERE e.status = true;";

	private String SQL_OBTAIN = "select e.id, e.cnpj, e.inscricao_estadual, e.razao_social,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade, " + "l.ufe_sg, l.log_nome "
			+ "FROM Empresa e INNER JOIN pessoa p ON (e.id = p.id)" + " INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ " WHERE e.status = true AND e.id = ?;";

	public void insert(Empresa e) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setLong(1, e.getId());
			ps.setLong(2, e.getCnpj());
			ps.setString(3, e.getRazaoSocial());
			ps.setLong(4, e.getInscricaoEstadual());
			
			ps.setLong(5, e.getId());
			ps.setLong(6, e.getCep());
			ps.setInt(7, e.getNumero());
			ps.setString(8, e.getComplemento());
			ps.setString(9, e.getEmail());
			ps.setString(10, e.getNome());
			ps.setString(11, e.getCidade());
			ps.setBoolean(12, true);

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void update(Empresa e) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setLong(1, e.getCnpj());
			ps.setString(2, e.getRazaoSocial());
			ps.setLong(3, e.getInscricaoEstadual());
			ps.setLong(4, e.getId());
			
			ps.setLong(5, e.getCep());
			ps.setInt(6, e.getNumero());
			ps.setString(7, e.getComplemento());
			ps.setString(8, e.getEmail());
			ps.setString(9, e.getNome());
			ps.setString(10, e.getCidade());
			ps.setBoolean(11, e.isStatus());
			ps.setLong(12, e.getId());
			
			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void delete(Empresa e) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setBoolean(1, e.isStatus());
			ps.setLong(2, e.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public List<Empresa> select() {

		List<Empresa> l = new ArrayList<Empresa>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Empresa e = new Empresa(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cnpj"), rs.getString("razaoSocial"), rs.getLong("inscricaoEstadual"),
						rs.getBoolean("status"));
				l.add(e);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Empresa obtain(Empresa e) {

		Empresa re = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, e.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Empresa e1 = new Empresa(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cnpj"), rs.getString("razaoSocial"), rs.getLong("inscricaoEstadual"),
						rs.getBoolean("status"));
				
				if(e1!=null) {
					re=e1;
				}
				
			}

			desconectar();

		}

		catch (Exception e1) {
			e1.printStackTrace();
		}

		return re;
	}

}