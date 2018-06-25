package br.com.vsetsistemas.services;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.vsetsistemas.model.Item;
import br.com.vsetsistemas.model.Produto;

public class ProdutoWebService {

	public List<Produto> listarTodos(){
		//Chamar serviço de obterPorCPF passando no final da URL o valor desejado
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/DressMeDynamic/rest/produto/list");

		//Informar o tipo de conteúdo que será enviado, o valor foi passado na linha anterior
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		//Se o retorno foi o código 200, então sucesso
		if (response.getStatus() == 200){
			String json = response.getEntity(String.class);
			
			//Instanciar Gson
			Gson gson = new Gson();
			List<Produto> lista = gson.fromJson(json, new TypeToken<List<Produto>>(){}.getType());

			return lista;
		}

		return null;
	}
	
	public void atualizarEstoque(Item i){
		//Instanciar Gson
		Gson gson = new Gson();
		
		//Transformar objeto em Json
		String json = gson.toJson(i);
		
		//Chamar serviço de inserir
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/DressMeDynamic/rest/produto/atualizarEstoque");
		
		//Informar o tipo de conteúdo que será enviado e o String com o Json
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
		
		//Se o retorno foi o código 201, então sucesso
		/*if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
*/
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
