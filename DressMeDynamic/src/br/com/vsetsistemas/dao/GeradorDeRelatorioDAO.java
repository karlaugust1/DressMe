package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class GeradorDeRelatorioDAO extends DAO{

/*	private String SQL_RELATORIO = "select * from notafiscal as nf inner join produto_notafiscal as pnf on pnf.numeronota = nf.numero inner join empresa e on e.id = nf.empresa;";
	
	public Map<String, Object> gerarParametros(){
		
		Map<String, Object> parametros = new HashMap<>();
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_RELATORIO);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			desconectar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
}
