package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;
import br.com.vsetsistemas.dao.PermissaoDAO;
import br.com.vsetsistemas.model.Permissao;

public class PermissaoSession {
	
	private PermissaoDAO dao = new PermissaoDAO();
	
	public List<Permissao> listAll(){
		
		List<Permissao> list = new ArrayList<>();
		
		try {
			
			list = dao.select();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Permissao obtainById(int id) {
		
		Permissao newP = null;
		newP = dao.obtain(new Permissao(id,""));
		return newP;
		
	}
	
}
