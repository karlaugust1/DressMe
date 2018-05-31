package br.com.vsetsistemas.model;


public class Funcionario extends Pessoa{

	private String login;
	private String senha;
	private Cargo cargo;
	private Boolean vendedor;
	
	public Funcionario(long id, String nome, int numero, String complemento, long cep, String cidade,
			String email, String login, String senha, Cargo cargo, Boolean status, Boolean vendedor) {
		
		super(id, nome, numero, complemento, cep, cidade, email, status);
		
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
		this.vendedor = vendedor;
	}

	public Funcionario() {
		super();
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

	public Boolean getVendedor() {
		return vendedor;
	}

	public void setVendedor(Boolean vendedor) {
		this.vendedor = vendedor;
	}
		
}

