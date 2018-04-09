package br.com.vsetsistemas.model;

public class Produto {

	private int id;
	private long EAN;
	private String descricao;
	private Boolean status;
	
	public Produto(int id, long eAN, String descricao, Boolean status) {
		this.id = id;
		EAN = eAN;
		this.descricao = descricao;
		this.setStatus(status);
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

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
