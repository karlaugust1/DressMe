package br.com.vsetsistemas.app;

import java.util.ArrayList;
import java.util.List;

import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

public class FuncionarioApp {

	public static void main(String[] args) {
		
		Cargo c = new Cargo(5, "Estagiário", true);
		Funcionario f = new Funcionario(1, "Karl August Harder", 7805, "Casa", 8370335, "Araucária", "karl-august2011@hotmail.com", "KARL", "666", c, true);

		FuncionarioSession fs = new FuncionarioSession();
		if(fs.authenticateFuncionario(f)) {
			System.out.println("Entrou");
		}else {
			System.out.println("Não entrou");
		}
		
		/*DELETAR APARTIR DAQUI, POIS É SÓ UM TESTE*/
		//INSERIR
		Funcionario newF = new Funcionario(3,"Alisson de Oliveira Teixeira", 8057, "Apartamento", 83703335, "Curitiba", "ally@waifu.club", "Allyiunininun","ALICELOVESYOU", c, true);
		//fs.insertFuncionario(newF);
		
		//ALTERAR
		newF.setLogin("u22w2w2w2");
		fs.updateFuncionario(newF);
		
		//DELETAR
		newF.setStatus(false);
		fs.deleteFuncionario(newF);
		
		//mostrar/consultar
		List<Funcionario> lista = new ArrayList<>();
		lista = fs.listAll();
		for(Funcionario f9 : lista) {
			System.out.println(f9.getLogin() + f9.getSenha());
		}
	}
}
