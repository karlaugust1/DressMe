package br.com.vsetsistemas.model;

public class Fornecedor {

	private long id;
	private long cnpj;
	private String razaoSocial;
	
	public Fornecedor(long id, long cnpj, String razaoSocial) {


		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	
	public Fornecedor() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	

}
