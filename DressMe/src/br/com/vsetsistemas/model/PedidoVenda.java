package br.com.vsetsistemas.model;

import java.util.Date;
import java.util.List;

public class PedidoVenda {

	private long numero;
	private Orcamento orcamento;
	private Date dataAbertura;
	private Date dataFechamento;
	private Cliente cliente;
	private CondicaoPagamento condPagamento;
	private Funcionario vendedor;
	private List<Produto> listaProduto;
	private boolean situacao;
	private double valorTotal;
	private double valorSubtotal;
	private double desconto;
	private boolean status;
	
	public PedidoVenda(long numero, Orcamento orcamento, Date dataAbertura, Date dataFechamento, Cliente cliente,
			CondicaoPagamento condPagamento, Funcionario vendedor, List<Produto> listaProduto, boolean situacao,
			double valorTotal, double valorSubtotal, double desconto, boolean status) {
		this.numero = numero;
		this.orcamento = orcamento;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.cliente = cliente;
		this.condPagamento = condPagamento;
		this.vendedor = vendedor;
		this.listaProduto = listaProduto;
		this.situacao = situacao;
		this.valorTotal = valorTotal;
		this.valorSubtotal = valorSubtotal;
		this.desconto = desconto;
		this.status = status;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CondicaoPagamento getCondPagamento() {
		return condPagamento;
	}

	public void setCondPagamento(CondicaoPagamento condPagamento) {
		this.condPagamento = condPagamento;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(double valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
