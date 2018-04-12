package br.com.vsetsistemas.model;

public class Produto {

	private long id;
	private long ean;
	private String descricao;
	private boolean status;
	private String nome;
	private String genero;
	private String tamanho;
	private String cor;
	private double preco;
	private Categoria categoria;
	private Fornecedor fornecedor;
	
	

	public Produto(long id, long ean, String descricao, boolean status, String nome, String genero, String tamanho,
			String cor, double preco, Categoria categoria, Fornecedor fornecedor) {
		this.id = id;
		this.ean = ean;
		this.descricao = descricao;
		this.status = status;
		this.nome = nome;
		this.genero = genero;
		this.tamanho = tamanho;
		this.cor = cor;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
	}

	public Produto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getEan() {
		return ean;
	}

	public void setEan(long ean) {
		this.ean = ean;
	}
	
	
}
