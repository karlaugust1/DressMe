package br.com.vsetsistemas.services;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.vsetsistemas.model.Cliente;

public class ClienteWebServices {
	
	public List<Cliente> listarTodos(){
		//Chamar servi�o de obterPorCPF passando no final da URL o valor desejado
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/DressMeDynamic/rest/cliente/list");

		//Informar o tipo de conte�do que ser� enviado, o valor foi passado na linha anterior
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		//Se o retorno foi o c�digo 200, ent�o sucesso
		if (response.getStatus() == 200){
			String json = response.getEntity(String.class);
			
			//Instanciar Gson
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			List<Cliente> lista = gson.fromJson(json, new TypeToken<List<Cliente>>(){}.getType());

			return lista;
		}

		return null;
	}
}
