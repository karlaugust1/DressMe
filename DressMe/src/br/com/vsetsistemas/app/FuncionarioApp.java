package br.com.vsetsistemas.app;

import java.util.ArrayList;
import java.util.List;
import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

public class FuncionarioApp {

	public static void main(String[] args) {
		
		Cargo c = new Cargo(5, "Estoquista", true);
		Funcionario f = new Funcionario(1, "Karl August Harder", 7805, "Casa", 8370335, "Araucária", "karl-august2011@hotmail.com", "karl", "666", c, true, false);

		FuncionarioSession fs = new FuncionarioSession();
		if(fs.authenticateFuncionario(f)) {
			System.out.println("Entrou");
		}else {
			System.out.println("Não entrou");
		}
		
		//DELETAR APARTIR DAQUI, POIS É SÓ UM TESTE
		//INSERIR
		Funcionario newF = new Funcionario(4,"Edu", 946, "Casa", 85816780, "Cascavel", "edu@facear.edu", "edu","edu123", c, true, false);
		fs.insertFuncionario(newF);
		
		//ALTERAR
		//newF.setLogin("EDUUU");
		//fs.updateFuncionario(newF);	
		
		//DELETAR
		//newF.setStatus(false);
		//fs.deleteFuncionario(newF);
		
		//mostrar/consultar
		List<Funcionario> lista = new ArrayList<>();
		lista = fs.listAll();
		for(Funcionario f9 : lista) {
			System.out.println(f9.getLogin());
		}
		/*
		fs.alterCargoFuncionario(newF);
		
		
		//parte do CS23 - Gerenciar vendedores
		FuncionarioDAO fdao = new FuncionarioDAO();
		//FuncionarioSession fs = new FuncionarioSession();
		Funcionario f1 = fdao.obtainByEmail("ally@waifu.club");
		System.out.println(f1.getVendedor());
		fs.alterCargoFuncionario(f1);*/
	}
}
