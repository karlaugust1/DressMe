package br.com.vsetsistemas.model;

public class Empresa extends Pessoa{

	private long cnpj;
	private String razaoSocial;
	private long inscricaoEstadual;
	
	public Empresa(long id, String nome, String rua, int numero, String complemento, long cep, String cidade,
			String estado, String pais, String email, long cnpj, String razaoSocial, long inscricaoEstadual) {
	
		super(id, nome, rua, numero, complemento, cep, cidade, estado, pais, email);
		
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
