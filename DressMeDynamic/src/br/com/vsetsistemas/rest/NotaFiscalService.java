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

import br.com.vsetsistemas.model.NotaFiscal;
import br.com.vsetsistemas.session.NotaFiscalSession;

@Path("/notafiscal")
public class NotaFiscalService {

	NotaFiscalSession session = new NotaFiscalSession();

}
