package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.PedidoVendaDAO;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;

public class PedidoVendaSession {

	private PedidoVendaDAO dao = new PedidoVendaDAO();
	
	public void insertPedidoVenda(PedidoVenda pv) {
		
		try {
			dao.insert(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatePedidoVenda(PedidoVenda pv) {
		
		try {
			dao.update(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePedidoVenda(PedidoVenda pv) {
		
		try {
			dao.delete(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PedidoVenda> listAll(){
		List<PedidoVenda> l = new ArrayList<>();
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public PedidoVenda obtain(PedidoVenda pv) {
		PedidoVenda retPv = null;
		try {
			retPv = dao.obtain(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retPv;
	}
	
	public void insertProduct(Produto p) {
		try {
			//dao.insertProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Produto p) {
		try {
			//dao.delteProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Produto p) {
		try {
			//dao.updateProduct;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> listAllProduct(){
		List<Produto> l = new ArrayList<>();
		try {
			//l = dao.selectProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public Produto obtainProduct() {
		Produto p = null;
		try {
			//p = dao.obtainProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public int converterEmPontos(double valor) {
		
		return (int) Math.round(valor);
		
	}
	
	
	
}
