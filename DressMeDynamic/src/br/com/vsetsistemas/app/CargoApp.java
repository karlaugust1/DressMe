package br.com.vsetsistemas.app;

import java.util.*;

import br.com.vsetsistemas.dao.CargoDAO;
import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.session.CargoSession;

public class CargoApp {

	public static void main(String[] args) {
		
		Cargo c = new Cargo(5, "teste", true);
		
		CargoSession cs = new CargoSession();
		
		//cs.insertCargo(c);

		List<Cargo> l = new ArrayList<>();
		CargoDAO cd = new CargoDAO();
		
		//l = cd.select();
		
		/*for(Cargo c1 : l) {
			System.out.println(c1.getId() + " - " + c1.getDescricao() + " - " + c1.isStatus());
		}
		*/
		/*//UPDATE
		c.setDescricao("WZEXRCTYUBMIOK");
		cs.updateCargo(c);*/
		l = cd.select();
		for(Cargo c1 : l) {
			System.out.println(c1.getId() + " - " + c1.getDescricao() + " - " + c1.isStatus());
		}
		
		//DELETE
		System.out.println("--------------------------------");
		c.setStatus(false);
		cs.deleteCargo(c);
		l = cd.select();
		for(Cargo c1 : l) {
			System.out.println(c1.getId() + " - " + c1.getDescricao() + " - " + c1.isStatus());
		}
		
	/*	//OBTAIN
		System.out.println("--------------------------------");
		Cargo c2 = cs.obtainCargo(c);
		System.out.println(c2.getId() + " - " + c2.getDescricao() + " - " + c2.isStatus());*/
	}
}
