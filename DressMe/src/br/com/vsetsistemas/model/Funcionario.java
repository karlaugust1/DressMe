package br.com.vsetsistemas.model;

import java.util.Date;

public class Funcionario extends Pessoa{

	private String login;
	private String senha;
	private Cargo cargo;
	private Date dataNascimento;
	
	public Funcionario(long id, String nome, String rua, int numero, String complemento, long cep, String cidade,
			String estado, String pais, String email, String login, String senha, Cargo cargo, Date dataNascimento) {
		
		super(id, nome, rua, numero, complemento, cep, cidade, estado, pais, email);
		
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
