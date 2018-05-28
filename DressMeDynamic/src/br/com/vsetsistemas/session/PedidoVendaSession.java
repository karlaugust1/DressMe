package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.PedidoVendaDAO;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;

public class PedidoVendaSession {

	private PedidoVendaDAO dao = new PedidoVendaDAO();
	
	public boolean insertPedidoVenda(PedidoVenda pv) {
		
		pv.setNumero(obtainLastRegister());
		pv.setNumeroPontos(convertIntoPoints(pv.getValorTotal()));
		
		try {
			dao.insert(pv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePedidoVenda(PedidoVenda pv) {
		
		try {
			dao.update(pv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletePedidoVenda(PedidoVenda pv) {
		
		try {
			dao.delete(pv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	
	public PedidoVenda obtainById(long numero) {
		PedidoVenda retPv = null;
		try {
			retPv = dao.obtainById(numero);
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
	
	public int convertIntoPoints(double valor) {
		
		return (int) Math.round(valor);
		
	}
	
	public boolean invoicePedidoVenda(PedidoVenda pv) {
		
		if(pv != null) {
			dao.invoice(pv);
			return true;
		}else {
			return false;
		}		
	}
	
	public long obtainLastRegister() {
		
		long i = dao.obtainLastRegister();
		return i;
	}
	
	public List<PedidoVenda> searchPedidoVenda(PedidoVenda pv){
		List<PedidoVenda> l = dao.search(pv);
		return l;
	}
	
}