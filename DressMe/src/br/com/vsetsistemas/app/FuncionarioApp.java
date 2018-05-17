package br.com.vsetsistemas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

import br.com.vsetsistemas.dao.FuncionarioDAO;
import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

public class FuncionarioApp {

	public static void main(String[] args) {
		
		Cargo c = new Cargo(5, "Estoquista", true);
		Funcionario f = new Funcionario(1, "Karl August Harder", 7805, "Casa", 8370335, "Araucária", "karl-august2011@hotmail.com", "KARL", "666", c, true, false);

		FuncionarioSession fs = new FuncionarioSession();
		if(fs.authenticateFuncionario(f)) {
			System.out.println("Entrou");
		}else {
			System.out.println("Não entrou");
		}
		
		//DELETAR APARTIR DAQUI, POIS É SÓ UM TESTE
		//INSERIR
		Funcionario newF = new Funcionario(2,"Alisson de Oliveira Teixeira", 8057, "Apartamento", 83703335, "Curitiba", "ally@waifu.club", "Allyiunininun","ALICELOVESYOU", c, true, true);
		//fs.insertFuncionario(newF);
		
		//ALTERAR
		//newF.setLogin("ALLLLLY ");
		fs.updateFuncionario(newF);
		
		//DELETAR
		//newF.setStatus(false);
		//fs.deleteFuncionario(newF);
		
		//mostrar/consultar
		List<Funcionario> lista = new ArrayList<>();
		lista = fs.listAll();
		for(Funcionario f9 : lista) {
			System.out.println(f9.getLogin() + f9.getSenha());
		}
		
		fs.alterCargoFuncionario(newF);
		
		
		//parte do CS23 - Gerenciar vendedores
		FuncionarioDAO fdao = new FuncionarioDAO();
		//FuncionarioSession fs = new FuncionarioSession();
		Funcionario f1 = fdao.obtainByEmail("ally@waifu.club");
		System.out.println(f1.getVendedor());
		fs.alterCargoFuncionario(f1);
	}
}
