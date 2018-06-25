package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.FuncionarioDAO;
import br.com.vsetsistemas.model.Funcionario;

public class FuncionarioSession {

	private FuncionarioDAO dao = new FuncionarioDAO();

	public boolean insertFuncionario(Funcionario f) {

		try {
			if (verifyFuncionario(f)) {
				dao.insert(f);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateFuncionario(Funcionario f) {

		try {
			if (verifyFuncionario(f)) {
				dao.update(f);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteFuncionario(Funcionario f) {

		try {
			dao.delete(f);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Funcionario> listAll() {

		List<Funcionario> lista = new ArrayList<>();

		try {
			lista = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public Funcionario getFuncionarioById(Long l) {
		
		try {
			return dao.obtainById(l);
		} catch (Exception e) {
		}
		return null;
	}

	public boolean verifyFuncionario(Funcionario f) {

		boolean retorno = true;

		if (f.getId() == 0) {
			retorno = false;
		} else if (f.getLogin() == null) {
			retorno = false;
		} else if (f.getSenha() == null) {
			retorno = false;
		} else if (f.getCargo() == null) {
			retorno = false;
		} else if (f.getCep() == 0) {
			retorno = false;
		} else if (f.isStatus() == null) {
			retorno = false;
		}

		return retorno;
	}

	public boolean authenticateFuncionario(Funcionario f) {

		boolean retorno = false;
		Funcionario newF = dao.obtainByEmail(f.getEmail());

		try {
			if (f.getEmail().equals(newF.getEmail()) && f.getSenha().equals(newF.getSenha())) {
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}

		return retorno;
	}

	public void alterCargoFuncionario(Funcionario f) {
		/*
		 * FuncionarioDAO fdao = new FuncionarioDAO(); Funcionario f1 = fdao.obtain(f);
		 * if(f.getVendedor() == false) { f.setVendedor(true); fdao.update(f); }else{
		 * f.setVendedor(false); fdao.update(f); }
		 */
		FuncionarioDAO fdao = new FuncionarioDAO();
		if (f.getVendedor()) {
			f.setVendedor(false);
			fdao.update(f);
		} else {
			f.setVendedor(true);
			fdao.update(f);
		}
	}
	
}
