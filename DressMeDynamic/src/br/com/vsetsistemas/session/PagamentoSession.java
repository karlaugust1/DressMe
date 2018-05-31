package br.com.vsetsistemas.session;

import br.com.vsetsistemas.dao.PagamentoDAO;
import br.com.vsetsistemas.model.Pagamento;

public class PagamentoSession {

	private PagamentoDAO dao = new PagamentoDAO();
	
	public boolean insertPagamento(Pagamento p) {
		
		try {
			dao.insert(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
