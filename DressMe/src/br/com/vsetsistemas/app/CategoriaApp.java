package br.com.vsetsistemas.app;

import java.util.ArrayList;
import java.util.List;
import br.com.vsetsistemas.model.Categoria;
import br.com.vsetsistemas.session.CategoriaSession;

public class CategoriaApp {

	public static void main(String[] args) {
		
	
		
		Categoria c = new Categoria();
		CategoriaSession cs = new CategoriaSession();
		List<Categoria> l = new ArrayList<>();
		l = cs.listAll();
		
		for(Categoria c1 : l) {
			System.out.println(c1.getId() + " - " + c1.getDescricao());
		}
	
		System.out.println("------------------");
		c.setId(1);
		Categoria c2 = cs.obtainCategoria(c);
		System.out.println(c2.getId() + " - "+ c2.getDescricao());
		
	}

}
