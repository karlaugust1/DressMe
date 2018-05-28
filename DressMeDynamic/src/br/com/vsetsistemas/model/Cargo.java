package br.com.vsetsistemas.model;

public class Cargo {

	private long id;
	private String descricao;
	private boolean status;
	
	public Cargo(long id, String descricao, boolean status) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
