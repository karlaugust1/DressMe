package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Fornecedor;

public class FornecedorDAO extends DAO {

	private String SQL_OBTAIN = "SELECT * FROM fornecedor WHERE id=?;";
	
	private String SQL_OBTAIN_BY_ID = "SELECT * FROM fornecedor WHERE id = ?";

	private String SQL_SELECT = "SELECT * FROM fornecedor;";

	public Fornecedor obtain(Fornecedor f) {

		Fornecedor reF = null;

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setLong(1, f.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Fornecedor f1 = new Fornecedor(rs.getLong("id"), rs.getLong("cnpj"), rs.getString("razao_social"));

				if (f1 != null) {
					reF = f1;
					break;
				}
			}

			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reF;

	}
	
	public Fornecedor obtainById(long i) {
		Fornecedor f = null;
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN_BY_ID);
			ps.setLong(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Fornecedor newF = new Fornecedor(rs.getLong("id"), rs.getLong("cnpj"), rs.getString("razao_social"));
				
				if(newF != null) {
					f = newF;
					break;
				}
			}
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public List<Fornecedor> select() {
		List<Fornecedor> l = new ArrayList<>();

		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Fornecedor f = new Fornecedor(rs.getLong("id"), rs.getLong("cnpj"), rs.getString("razao_social"));
				l.add(f);
			}
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

}
