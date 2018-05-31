package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;

import br.com.vsetsistemas.model.Pagamento;

public class PagamentoDAO extends DAO {

		private String SQL_INSERT = "INSERT INTO pagamento (id, data_vencimento, data_pagamento, status, id_cond_pagamento, numero_parcela) VALUES (?,?,?,?,?,?);";
		
		public void insert(Pagamento p) {
			
			try {
				conectar();
				
				PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
				ps.setInt(1, p.getId());
				//ps.setDate(2, p.getDataVencimento());
				//ps.setDate(3, p.getDataPagamento());
				ps.setString(4, p.getStatus());
				ps.setInt(5, p.getCondPagamento().getId());
				ps.setInt(6, p.getNumeroParcela());
				ps.executeUpdate();
				
				desconectar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
