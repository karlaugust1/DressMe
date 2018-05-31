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

import br.com.vsetsistemas.model.Cargo;
import br.com.vsetsistemas.session.CargoSession;

@Path("/Cargo")
public class CargoService {
	
	CargoSession session = new CargoSession();

	@GET
	@Path("/obtain")
	@Produces(MediaType.APPLICATION_JSON)
	public Cargo obtainCargo(@QueryParam("numero")long numero) {
	
		Cargo c = session.obtainCargo(numero);
		return c;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {

		List<Cargo> lista = session.listAll();
		
		if(lista == null || lista.size() == 0) {
			return Response.status(400).entity("Sem cargos cadastrados!").build();
		}
		return Response.status(200).entity(lista).build();
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirCargo(Cargo c){
		
		String result = "Cargo inserido com sucesso";
		
		if(this.session.insertCargo(c)){			
			return Response.status(201).entity(result).build();
		}
		
		result = "Cargo não foi inserido com sucesso";
		return Response.status(400).entity(result).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCargo(Cargo c){
		
		String result = "Cargo alterado com sucesso";
		if(this.session.updateCargo(c)){
			return Response.status(201).entity(result).build();			
		}
		result = "Cargo não foi alterado com sucesso";
		return Response.status(400).entity(result).build();	
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCargo(@QueryParam("id") Long numero){
		
		Cargo c = new Cargo();
		c.setId(numero);
		String result = "Cargo excluido com sucesso";
		if(session.deleteCargo(c)) {
			return Response.status(200).entity(result).build();
		}else {
			result = "Cargo não foi excluido com sucesso";
			return Response.status(400).entity(result).build();
		}
	}
}
