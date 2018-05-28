package br.com.vsetsistemas.model;

public class CondicaoPagamento {

	private int id;
	private String descricao;
	
	public CondicaoPagamento(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public CondicaoPagamento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
