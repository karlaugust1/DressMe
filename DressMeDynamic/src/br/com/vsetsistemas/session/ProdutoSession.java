package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.ProdutoDAO;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.Produto;

public class ProdutoSession {

	private ProdutoDAO dao = new ProdutoDAO();
	
	public Produto obtain(Produto p) {
		Produto retp = null;
		try {
			p = dao.obtain(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retp;
	}

	public List<Produto> listAll(){
		List<Produto> l = new ArrayList<>();
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public Produto obtainById(int i) {
		Produto p = null;
		try {
			p = dao.obtainById(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void updateEstoque(Item i) {
		
		try {

			Produto p = this.obtainById(i.getProduto().getId());
			p.setQuantidadeEstoque(p.getQuantidadeEstoque()-i.getQuantidade());
			dao.update(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
