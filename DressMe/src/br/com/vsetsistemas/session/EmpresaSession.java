package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.EmpresaDAO;
import br.com.vsetsistemas.model.Empresa;

public class EmpresaSession {

	private EmpresaDAO dao = new EmpresaDAO();
	
	public boolean updateEmpresa(Empresa e) {
		
		try {
			dao.update(e);
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
		
	}
	
	public Empresa obtainByCnpj(long l) {
		
		Empresa re = null;
		try {
			re = dao.obtainByCnpj(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public List<Empresa> listAll(){
		
		List<Empresa> lista = new ArrayList<>();
		
		try {
			
			lista = dao.select();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
