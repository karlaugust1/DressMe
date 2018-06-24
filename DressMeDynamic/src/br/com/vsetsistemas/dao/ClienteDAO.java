package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Cliente;

public class ClienteDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO cliente (id, data_nascimento, rg, inscricao_estadual, telefoneCelular, telefoneResidencial, telefoneComercial, cpf) values(?, ?, ?, ?, ?, ?, ?, ?);"
			+ "INSERT INTO pessoa (id, cep, numero, complemento, email, nome, cidade, status, qtd_pontos) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private String SQL_UPDATE = "UPDATE cliente SET data_nascimento=?, rg=?, inscricao_estadual=?, telefoneCelular=?, telefoneResidencial=?, telefoneCo	mercial=?, cpfcnpj=?, juridico=?, qtd_pontos = ? WHERE id = ?;";
			//+ "UPDATE pessoa SET cep=?, numero=?, complemento=?, email=?, nome=?, cidade=?, status=?,  WHERE id=?";

	private String SQL_DELETE = "UPDATE pessoa SET status = ? WHERE id = ?;";

	private String SQL_SELECT = "select c.id, c.data_nascimento, c.rg, c.inscricao_estadual, c.telefoneCelular, c.telefoneResidencial, c.telefoneComercial, c.Cpfcnpj,c.juridico,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade, " + "l.ufe_sg, l.log_nome, p.status, c.qtd_pontos "
			+ "FROM Cliente c INNER JOIN pessoa p ON (c.id = p.id)" + " INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ " WHERE p.status = true;";

	private String SQL_OBTAIN = "select c.id, c.data_nascimento, c.rg, c.inscricao_estadual, c.telefoneCelular, c.telefoneResidencial, c.telefoneComercial, c.Cpfcnpj,"
			+ "			p.numero, p.complemento, p.email, p.nome, p.cidade, l.ufe_sg, l.log_nome, p.cep, p.status, c.qtd_pontos,c.juridico"
			+ "			FROM Cliente c INNER JOIN pessoa p ON (c.id = p.id) INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ "			WHERE p.status = true AND c.id = ?;";

	private String SQL_OBTAIN_BY_CPF = "select c.id, c.data_nascimento, c.rg, c.inscricao_estadual, c.telefoneCelular, c.telefoneResidencial, c.telefoneComercial, c.cpfcnpj,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade, p.status, c.qtd_pontos, c.juridico," + "l.ufe_sg, l.log_nome "
			+ "FROM Cliente c INNER JOIN pessoa p ON (c.id = p.id)" + " INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ " WHERE p.status = true AND c.cpf = ?;";

	private String SQL_OBTAIN_BY_ID = "select c.id, c.data_nascimento, c.rg, c.inscricao_estadual, c.telefoneCelular, c.telefoneResidencial, c.telefoneComercial, c.cpfcnpj,"
			+ "p.cep, p.numero, p.complemento, p.email, p.nome, p.cidade, p.status, c.qtd_pontos,c.juridico," + "l.ufe_sg, l.log_nome "
			+ "FROM Cliente c INNER JOIN pessoa p ON (c.id = p.id)" + " INNER JOIN log_logradouro l ON (p.cep = l.cep)"
			+ " WHERE p.status = true AND c.id = ?;";

	private String SQL_COUNT_CLIENTES = "SELECT DISTINCT COUNT(ID) QUANTIDADE FROM CLIENTE;";
	
	private String SQL_UPDATE_POINTS = "UPDATE cliente SET qtd_pontos = ? WHERE id = ?;";
	
	public int countClientes() {
		int i = 0;
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_COUNT_CLIENTES);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				i = rs.getInt("quantidade");
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public void insert(Cliente c) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setLong(1, c.getId());
			ps.setDate(2, c.getDataNascimento());
			ps.setLong(3, c.getRg());
			ps.setLong(4, c.getInscricaoEstadual());
			ps.setString(5, c.getTelefoneCelular());
			ps.setString(6, c.getTelefoneResidencial());
			ps.setString(7, c.getTelefoneComercial());

			ps.setLong(8, c.getCpf());
			ps.setLong(9, c.getId());
			ps.setLong(10, c.getCep());
			ps.setInt(11, c.getNumero());
			ps.setString(12, c.getComplemento());
			ps.setString(13, c.getEmail());
			ps.setString(14, c.getNome());
			ps.setString(15, c.getCidade());
			ps.setBoolean(16, true);
			ps.setInt(17, c.getQtdPontos());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Cliente c) {

		try {

			conectar();
			//UPDATE cliente SET data_nascimento=?, rg=?, inscricao_estadual=?, 
			//telefoneCelular=?, telefoneResidencial=?, telefoneComercial=?, cpfcnpj=?, juridico=?, qtd_pontos = ? WHERE id = ?
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setDate(1, c.getDataNascimento());
			ps.setLong(2, c.getRg());
			ps.setLong(3, c.getInscricaoEstadual());
			ps.setString(4, c.getTelefoneCelular());
			ps.setString(5, c.getTelefoneResidencial());
			ps.setString(6, c.getTelefoneComercial());
			ps.setLong(7, c.getCpf());
			ps.setBoolean(8, c.isJuridico());
			ps.setInt(9, c.getQtdPontos());
			ps.setLong(10, c.getId());
/*
			ps.setLong(9, c.getCep());
			ps.setInt(10, c.getNumero());
			ps.setString(11, c.getComplemento());
			ps.setString(12, c.getEmail());
			ps.setString(13, c.getNome());
			ps.setString(14, c.getCidade());
			ps.setBoolean(15, c.isStatus());
			ps.setLong(16, c.getId());
			ps.setInt(17, c.getQtdPontos());
*/
			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Cliente c) {

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
	
	public void updatePoints(Cliente c) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_POINTS);

			ps.setInt(1, c.getQtdPontos());
			ps.setLong(2, c.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> select() {

		List<Cliente> l = new ArrayList<Cliente>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cpfcnpj"), rs.getDate("data_nascimento"), rs.getLong("rg"),
						rs.getLong("inscricao_estadual"), rs.getString("telefoneCelular"),
						rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"),
						rs.getBoolean("status"), rs.getString("log_nome"), rs.getInt("qtd_pontos"), rs.getBoolean("juridico"));
				l.add(c);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public Cliente obtain(Cliente c) {

		Cliente rc = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, c.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente c1 = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cpfcnpj"), rs.getDate("data_nascimento"), rs.getLong("rg"),
						rs.getLong("inscricao_estadual"), rs.getString("telefoneCelular"),
						rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"),
						rs.getBoolean("status"), rs.getString("log_nome"), rs.getInt("qtd_pontos"),rs.getBoolean("juridico"));

				if (c1 != null) {
					rc = c1;
				}

			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rc;
	}

	public Cliente obtainByCpf(long l) {

		Cliente c = null;

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_CPF);
			ps.setLong(1, l);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c1 = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cpfcnpj"), rs.getDate("data_nascimento"), rs.getLong("rg"),
						rs.getLong("inscricao_estadual"), rs.getString("telefoneCelular"),
						rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"),
						rs.getBoolean("status"), rs.getString("log_nome"),rs.getInt("qtd_pontos"),rs.getBoolean("juridico"));

				if (c1 != null) {
					c = c1;
					break;
				}
			}

			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public Cliente obtainById(long l) {

		Cliente c = null;

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_ID);

			ps.setLong(1, l);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente c1 = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getLong("cep"), rs.getString("cidade"), rs.getString("email"),
						rs.getLong("cpfcnpj"), rs.getDate("data_nascimento"), rs.getLong("rg"),
						rs.getLong("inscricao_estadual"), rs.getString("telefoneCelular"),
						rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"),
						rs.getBoolean("status"), rs.getString("log_nome"),rs.getInt("qtd_pontos"),rs.getBoolean("juridico"));

				if (c1 != null) {
					c = c1;
					break;
				}
			}

			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
}