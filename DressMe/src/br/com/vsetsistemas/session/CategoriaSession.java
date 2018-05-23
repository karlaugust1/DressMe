package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.CategoriaDAO;
import br.com.vsetsistemas.model.Categoria;

public class CategoriaSession {

	private CategoriaDAO dao = new CategoriaDAO();
	
	public Categoria obtainCategoria(Categoria c) {
		
		Categoria retC = null;
		
		try {
			retC = dao.obtain(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retC;
		
	}
	
	public List<Categoria> listAll(){
		
		List<Categoria> l = new ArrayList<>();
		
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
		
	}
}
