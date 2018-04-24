package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.CargoDAO;
import br.com.vsetsistemas.model.Cargo;

public class CargoSession {

	private CargoDAO dao = new CargoDAO();
	
	public void insertCargo(Cargo c) {
		
		try {
			dao.insert(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateCargo(Cargo c) {
		try {
			dao.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCargo(Cargo c) {
		try {
			dao.delete(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Cargo> listAll(){
		
		List<Cargo> l = new ArrayList<>();
		
		try {
			l = dao.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	public Cargo obtainCargo(Cargo c) {
		Cargo c1 = null;
		try {
			c1 = dao.obtain(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c1;
	}
}
