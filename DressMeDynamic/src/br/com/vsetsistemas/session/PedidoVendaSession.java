package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.PedidoVendaDAO;
import br.com.vsetsistemas.model.Cliente;
import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.PedidoVenda;
import br.com.vsetsistemas.model.Produto;
import br.com.vsetsistemas.servlet.InserirClienteServlet;

public class PedidoVendaSession {

	private PedidoVendaDAO dao = new PedidoVendaDAO();

	public int countPedidoVendasMes() {

		try {
			return dao.obtainCountPedidosMonth();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double sumAllValues() {

		try {
			return dao.obtainSumAllValues();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	public int countPedidoVendas() {
		try {
			return dao.obtainCountPedidos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean insertPedidoVenda(PedidoVenda pv) {

		//pv.setNumeroPontos(convertIntoPoints(pv.getValorTotal()));

		try {
			dao.insert(pv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertOrcamento(PedidoVenda pv) {

		// pv.setNumero(obtainLastRegister());
		//pv.setNumeroPontos(convertIntoPoints(pv.getValorTotal()));

		try {
			dao.insertBudget(pv);
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

	public List<PedidoVenda> listAll() {
		List<PedidoVenda> l = new ArrayList<>();
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public List<PedidoVenda> listAllBudges() {
		List<PedidoVenda> l = new ArrayList<>();
		try {
			l = dao.selectBudges();
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

	public void insertProduct(Item i) {

		try {
			dao.insertProduct(i);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(Produto p) {
		try {
			// dao.delteProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(Produto p) {
		try {
			// dao.updateProduct;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Item> listAllProduct(PedidoVenda pv) {
		List<Item> l = new ArrayList<>();
		try {
			l = dao.selectProduct(pv.getNumero());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public Produto obtainProduct() {
		Produto p = null;
		try {
			// p = dao.obtainProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public int convertIntoPoints(double valor) {

		return (int) Math.round(valor);

	}

	public boolean invoicePedidoVenda(PedidoVenda pv) {

		if (pv != null) {
			dao.invoice(pv);
			return true;
		} else {
			return false;
		}
	}

	public PedidoVenda loadInitialParameters() {

		PedidoVenda pv = new PedidoVenda();
		pv.setNumero(dao.obtainLastRegister());
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		java.sql.Date dataSql = new java.sql.Date(date.getTime());
		pv.setDataAbertura(dataSql);

		return pv;
	}

	public long obtainLastRegister() {
		return dao.obtainLastRegister();

	}

	public List<PedidoVenda> searchPedidoVenda(PedidoVenda pv) {
		List<PedidoVenda> l = dao.search(pv);
		return l;
	}

	public List<PedidoVenda> searchOrcamento(PedidoVenda pv) {
		List<PedidoVenda> l = dao.search(pv);
		return l;
	}

	public boolean toPedidoVenda(PedidoVenda pv) {

		try {
			pv.setOrcamento(false);
			dao.update(pv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void deleteProdutoPedido(PedidoVenda pv) {
		try {
			dao.deleteProductPedido(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
