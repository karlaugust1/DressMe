package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.FornecedorDAO;
import br.com.vsetsistemas.model.Fornecedor;

public class FornecedorSession {

	private FornecedorDAO dao = new FornecedorDAO();
	
	public Fornecedor obtainFornecedor(Fornecedor f) {
		
		Fornecedor newF = null;
		try {
			
			newF = dao.obtain(f);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newF;
	}
	
	public List<Fornecedor> listAll(){
		
		List<Fornecedor> l = new ArrayList<>();
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
