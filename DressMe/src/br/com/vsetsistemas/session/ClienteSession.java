package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.ClienteDAO;
import br.com.vsetsistemas.model.Cliente;

public class ClienteSession {

	private ClienteDAO dao = new ClienteDAO();
		
	public void updateCliente(Cliente c) {
		
		try {
			
			dao.update(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteCliente(Cliente c) {
		
		try {
			
			dao.delete(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Cliente obtainByCpf(Cliente c) {
	
		Cliente c1 = null;
		
		try {
			c1 = dao.obtainByCpf(c.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}
	
	public List<Cliente> listAll(){
		
		List<Cliente> lista = new ArrayList<>();
		
		try {
			
			lista = dao.select();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean verifyCliente(Cliente c) {
		
		if(c.getCpf() == 0) {
			return false;
		}else if(c.getDataNascimento() == null) {
			return false;
		}else if(c.getRg() == 0) {
			return false;
		}else if(c.getInscricaoEstadual() == 0) {
			return false;
		}else if(c.getTelefoneCelular() == null) {
			return false;
		}else if(c.getTelefoneResidencial() == null) {
			return false;
		}else if(c.getTelefoneComercial() == null) {
			return false;
		}else if(c.getNumero() == 0) {
			return false;
		}else if(c.getComplemento() == null) {
			return false;
		}else if(c.getCep() == 0) {
			return false;
		}else if(c.getEmail().isEmpty()){
			return false;
		}else 
			return true;
		
	}
}
