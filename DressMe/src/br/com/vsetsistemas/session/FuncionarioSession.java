package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.FuncionarioDAO;
import br.com.vsetsistemas.model.Funcionario;

public class FuncionarioSession {

	private FuncionarioDAO dao = new FuncionarioDAO();

	public void insertFuncionario(Funcionario f) {

		try {
			dao.insert(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateFuncionario(Funcionario f) {
		
		try {
			dao.update(f);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteFuncionario(Funcionario f) {
		
		try {
			dao.delete(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listAll(){
		
		List<Funcionario> lista = new ArrayList<>();
		
		try {
			lista = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean verifyFuncionario(Funcionario f) {

		boolean retorno = true;

		if(f.getId() == 0) {
			retorno = false;
		}else if(f.getLogin() == null) {
			retorno = false;
		}else if(f.getSenha() == null) {
			retorno = false;
		}else if(f.getCargo() == null) {
			retorno = false;
		}else if(f.getCep() == 0) {
			retorno = false;
		}else if(f.isStatus() == null) {
			retorno = false;
		}
	
		return retorno;
	}
	
	public boolean authenticateFuncionario(Funcionario f) {
		
		
		
		boolean retorno = false;
		Funcionario newF = dao.obtainByEmail("karl-august2011@hotmail.com1");
		try{
			if(f.getEmail().equals(newF.getEmail()) && f.getSenha().equals(newF.getSenha())) {
				retorno = true;
			}
		}catch(Exception e) {
			System.out.println("Nome de usu�rio e/ou senha informados est�o incorretos");
			retorno = false;
		}
		
		return retorno;
	}
	
	public void alterCargoFuncionario(Funcionario f) {
		/*
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f1 = fdao.obtain(f);
		if(f.getVendedor() == false) {
			f.setVendedor(true);
			fdao.update(f);
		}else{
			f.setVendedor(false);
			fdao.update(f);
		}	
		*/
		FuncionarioDAO fdao = new FuncionarioDAO();
		if(f.getVendedor()) {
			f.setVendedor(false);
			fdao.update(f);
		}else {
			f.setVendedor(true);
			fdao.update(f);
		}
	}
}
