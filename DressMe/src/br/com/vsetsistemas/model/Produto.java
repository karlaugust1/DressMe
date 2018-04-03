package br.com.vsetsistemas.model;

public class Produto {

	private int id;
	private long EAN;
	private String descricao;
	
	public Produto(int id, long eAN, String descricao) {
		this.id = id;
		EAN = eAN;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getEAN() {
		return EAN;
	}

	public void setEAN(long eAN) {
		EAN = eAN;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
