package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.CondicaoPagamento;

public class CondicaoPagamentoDAO extends DAO {

	private String SQL_INSERT = "INSERT INTO condicao_pagamento (id, descricao) values(?, ?);";

	private String SQL_UPDATE = "UPDATE condicao_pagamento SET descricao=? WHERE id = ?;";

	private String SQL_DELETE = "DELETE FROM condicao_pagamento WHERE id = ?;";

	private String SQL_SELECT = "select * from condicao_pagamento;";

	private String SQL_OBTAIN = "select * from condicao_pagamento WHERE id = ?;";

	public void insert(CondicaoPagamento cp) {

		try {
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			ps.setInt(1, cp.getId());
			ps.setString(2, cp.getDescricao());

			ps.executeUpdate();

			desconectar();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(CondicaoPagamento cp) {

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

			ps.setString(1, cp.getDescricao());
			ps.setInt(2, cp.getId());
			

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(CondicaoPagamento cp) {

		try {

			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);

			ps.setInt(1, cp.getId());

			ps.executeUpdate();

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<CondicaoPagamento> select() {

		List<CondicaoPagamento> l = new ArrayList<CondicaoPagamento>();

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CondicaoPagamento cp = new CondicaoPagamento(rs.getInt("id"), rs.getString("descricao"));
				l.add(cp);
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	public CondicaoPagamento obtain(CondicaoPagamento cp) {
		CondicaoPagamento rcp = null;

		try {

			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTAIN);
			ps.setInt(1, cp.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rcp = new CondicaoPagamento(rs.getInt("id"), rs.getString("descricao"));
				break;
			}

			desconectar();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return rcp;
	}

}