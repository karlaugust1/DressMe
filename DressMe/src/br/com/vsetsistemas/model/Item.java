package br.com.vsetsistemas.model;

public class Item {

	private long id;
	private Produto produto;
	private int quantidade;
	private double desconto;
	private double subtotal;
	private double valorUnitario;
	private PedidoVenda pedido;
	
	public Item(long id, Produto produto, int quantidade, double desconto, double subtotal, double valorUnitario, PedidoVenda pedido) {
		
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.subtotal = subtotal;
		this.valorUnitario = valorUnitario;
		this.pedido = pedido;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public PedidoVenda getPedido() {
		return pedido;
	}
	public void setPedido(PedidoVenda pedido) {
		this.pedido = pedido;
	}
	
}
