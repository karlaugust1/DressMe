package br.com.vsetsistemas.model;

public class Empresa extends Pessoa{


	private long cnpj;
	private String razaoSocial;
	private long inscricaoEstadual;
	
	public Empresa(long id, String nome, int numero, String complemento, long cep, String cidade,
			 String email, long cnpj, String razaoSocial, long inscricaoEstadual, Boolean status) {
	
		super(id, nome, numero, complemento, cep, cidade, email, status);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
}
