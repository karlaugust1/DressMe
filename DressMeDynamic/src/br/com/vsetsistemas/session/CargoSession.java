package br.com.vsetsistemas.session;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.dao.CargoDAO;
import br.com.vsetsistemas.model.Cargo;

public class CargoSession {

	private CargoDAO dao = new CargoDAO();
	
	public boolean insertCargo(Cargo c) {
		
		try {
			dao.insert(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateCargo(Cargo c) {
		try {
			dao.update(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteCargo(Cargo c) {
		try {
			dao.delete(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	
	public Cargo obtainCargo(long id) {
		Cargo c1 = null;
		try {
			c1 = dao.obtain(new Cargo(id,"",true));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c1;
	}
	
}
