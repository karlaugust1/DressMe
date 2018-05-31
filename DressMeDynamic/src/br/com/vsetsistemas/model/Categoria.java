package br.com.vsetsistemas.model;

public class Categoria {

	private long id;
	private String descricao;
	
	public Categoria(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Categoria() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	
	
	
}
