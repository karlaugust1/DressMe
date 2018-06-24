package br.com.vsetsistemas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.CondicaoPagamento;
import br.com.vsetsistemas.model.Empresa;
import br.com.vsetsistemas.model.NotaFiscal;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.session.PedidoVendaSession;

public class NotaFiscalDAO extends DAO {

	private String SQL_SELECT = "select * from notafiscal;";

	public List<NotaFiscal> select() {
		List<NotaFiscal> lista = new ArrayList<>();
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NotaFiscal nf = new NotaFiscal();

				PedidoVendaSession pvs = new PedidoVendaSession();
				PedidoVenda pv = pvs.obtainById(rs.getLong("pedidovenda"));

				CondicaoPagamento cp = new CondicaoPagamento();
				cp.setId(rs.getInt("condpag"));

				Empresa e = new Empresa();
				e.setId(rs.getLong("empresa"));

				nf.setNumero(rs.getLong("numero"));
				nf.setSerie(rs.getInt("serie"));
				nf.setChaveDeAcesso(rs.getLong("chave_de_acesso"));
				nf.setDataEmissao(rs.getDate("data_emissao"));
				nf.setDataEntradaSaida(rs.getDate("data_entrada_saida"));
				nf.setCondPagamento(cp);
				nf.setPedidoVenda(pv);
				nf.setEmpresa(e);

				if (nf != null) {
					lista.add(nf);
				}
			}
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
