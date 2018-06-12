package br.com.vsetsistemas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vsetsistemas.model.Funcionario;
import br.com.vsetsistemas.session.FuncionarioSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Funcionario f = new Funcionario();
		f.setEmail(request.getParameter("email"));
		f.setSenha(request.getParameter("senha"));
		
		System.out.println("1");
		FuncionarioSession fsession = new FuncionarioSession();
		
		if(fsession.authenticateFuncionario(f)) {
			HttpSession session = request.getSession();
			System.out.println("2");
			session.setAttribute("email", f.getEmail());
			response.sendRedirect("index2.jsp");
			
		}else {
			response.sendRedirect("login.html");
			System.out.println("fim");
		}
		/*
		if(email.equals("karl-august2011@hotmail.com") && password.equals("666")) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("index2.jsp");

		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
