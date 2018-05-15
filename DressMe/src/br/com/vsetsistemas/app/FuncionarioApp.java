package br.com.vsetsistemas.app;

import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

public class FuncionarioApp {

	public static void main(String[] args) {
		
		Cargo c = new Cargo(4, "Estagiário", true);
		Funcionario f = new Funcionario(1, "Karl August Harder", 7805, "Casa", 8370335, "Araucária", "karl-august2011@hotmail.com", "KARL", "666", c, true);

		FuncionarioSession fs = new FuncionarioSession();
		if(fs.authenticateFuncionario(f)) {
			System.out.println("Entrou");
		}
	}
}
