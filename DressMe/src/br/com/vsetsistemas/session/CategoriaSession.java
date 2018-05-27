package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.CategoriaDAO;
import br.com.vsetsistemas.model.Categoria;

public class CategoriaSession {

	private CategoriaDAO dao = new CategoriaDAO();
	
	public Categoria obtainCategoria(long id) {
		
		Categoria retC = null;
		
		try {
			retC = dao.obtain(new Categoria(id, ""));
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
