package br.com.vsetsistemas.model;

public class Item {

	private int id;
	private Produto produto;
	private int quantidade;
	private double desconto;
	private double subtotal;
	private double valorUnitario;
	
	public Item(int id, Produto produto, int quantidade, double desconto, double subtotal, double valorUnitario) {
		
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.subtotal = subtotal;
		this.valorUnitario = valorUnitario;
	}
	
	public Item() {	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
