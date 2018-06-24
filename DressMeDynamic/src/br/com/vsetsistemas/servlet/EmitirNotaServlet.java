package br.com.vsetsistemas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vsetsistemas.db.ConnectDB;
import br.com.vsetsistemas.model.GeradorDeRelatorios;

/**
 * Servlet implementation class EmitirNotaServlet
 */
@WebServlet("/EmitirNotaServlet")
public class EmitirNotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public EmitirNotaServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// acha jrxml dentro da aplicação
		ServletContext contexto = request.getServletContext();
		String jrxml = contexto.getRealPath("/relatorios/nfce.jrxml");

		// prepara parâmetros
		Map<String, Object> parametros = new HashMap<>();

		// abre conexão com o banco
		Connection conexao;
		try {
			conexao = new ConnectDB().getConnection();

		// gera relatório
		GeradorDeRelatorios gerador = new GeradorDeRelatorios();
		gerador.gerar(jrxml, Long.parseLong(request.getParameter("numero")), response.getOutputStream());

		conexao.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
