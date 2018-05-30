package br.com.vsetsistemas.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vsetsistemas.session.FuncionarioSession;
import br.com.vsetsistemas.model.Funcionario;

@Path("/funcionario")
public class FuncionarioService {

	FuncionarioSession session = new FuncionarioSession();
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		
		List<Funcionario> lf = session.listAll();
		
		if(lf == null || lf.size()==0) {
		return Response.status(400).entity("Não existem funcionários cadastrados!").build();
		}
		return Response.status(200).entity(lf).build();
		
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertFuncionario(Funcionario f) {
		
		String result = "Funcionário cadastrado com sucesso!";
		
		if(this.session.insertFuncionario(f)) {
			return Response.status(201).entity(result).build();
		}
		
		result = "Funcionário não foi inserido com sucesso";
		return Response.status(400).entity(result).build();
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePedidoVenda(Funcionario f){
		
		String result = "Funcionário alterado com sucesso!";
		if(this.session.updateFuncionario(f)){
			return Response.status(201).entity(result).build();			
		}
		result = "Funcionário n縊 foi alterado com sucesso";
		return Response.status(400).entity(result).build();	
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFuncionario(@QueryParam("id") Long id){
		
		Funcionario f = new Funcionario();
		f.setId(id);
		String result = "Pedido de venda excluído com sucesso";
		if(session.deleteFuncionario(f)) {
			return Response.status(200).entity(result).build();
		}else {
			result = "Pedido de venda n縊 foi excluido com sucesso";
			return Response.status(400).entity(result).build();
		}
	}
	
	@PUT
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateFuncionario(Funcionario f) {
	
		
		String result = "Logado!";
		
		if(session.authenticateFuncionario(f)==true)
			return Response.status(200).entity(result).build();
		else {
			result = "Usuário ou senha inválidos!";
			return Response.status(400).entity(result).build();
		}
	}
}
