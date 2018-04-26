package br.com.vsetsistemas.session;

import br.com.vsetsistemas.dao.PagamentoDAO;
import br.com.vsetsistemas.model.Pagamento;

public class PagamentoSession {

	private PagamentoDAO dao = new PagamentoDAO();
	
	public void insertPagamento(Pagamento p) {
		
		try {
			dao.insert(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
