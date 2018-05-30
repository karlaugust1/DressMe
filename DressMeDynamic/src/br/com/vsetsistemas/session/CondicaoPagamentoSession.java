package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.CondicaoPagamentoDAO;
import br.com.vsetsistemas.model.CondicaoPagamento;

public class CondicaoPagamentoSession {

	private CondicaoPagamentoDAO dao = new CondicaoPagamentoDAO();
	
	public CondicaoPagamento obtainCondicaoPagamento(CondicaoPagamento p) {
		
		CondicaoPagamento cp = null;
		try {
			cp = dao.obtain(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cp;
	}
	
	public List<CondicaoPagamento> listAll(){
		List<CondicaoPagamento> l = new ArrayList<>();
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
		
	}
	
public CondicaoPagamento obtainById(int id) {
		
		CondicaoPagamento cp = null;
		try {
			cp = dao.obtainById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cp;
	}
}
