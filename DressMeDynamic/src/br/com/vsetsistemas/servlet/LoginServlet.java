package br.com.vsetsistemas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vsetsistemas.dao.FuncionarioDAO;
import br.com.vsetsistemas.model.Funcionario;
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Funcionario f = new Funcionario();
		f.setEmail(request.getParameter("email"));
		f.setSenha(request.getParameter("senha"));
		if(f.getEmail().equals("karl-august2011@hotmail.com")) {
			if(f.getSenha().equals("666")) {
				request.getRequestDispatcher("../WebContent/index2.html" ).forward(request, response);
			}
		}
		
		
		
		
		
		
		/*
		if(request.getParameter("login") != null){
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(email != null && !email.isEmpty()) {
			if(senha != null && !senha.isEmpty()) {
				Funcionario f = new Funcionario();
				f.setEmail(email);
				f.setSenha(senha);
				
				FuncionarioDAO fdao = new FuncionarioDAO();
				try {
					Funcionario flogando = fdao.obtainByEmail(email);
					if(flogando.getEmail() == null || flogando.getEmail().isEmpty()) {
						System.out.println("Não encontrou o email");
					}else if(flogando.getSenha().equalsIgnoreCase(f.getSenha())){
						
						String nextJSP = "/WebContent/index2.html";
				        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				        dispatcher.forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		}
		*/
	}
}
