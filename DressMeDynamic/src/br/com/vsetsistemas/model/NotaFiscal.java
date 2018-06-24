package br.com.vsetsistemas.model;

import java.util.Date;

public class NotaFiscal {

	private long numero;
	private int serie;
	private long chaveDeAcesso;
	private Date dataEmissao;
	private Date dataEntradaSaida;
	private CondicaoPagamento condPagamento;
	private PedidoVenda pedidoVenda;
	private Empresa empresa;
	
	public NotaFiscal(long numero, int serie, long chaveDeAcesso, Date dataEmissao, Date dataEntradaSaida,
			 CondicaoPagamento condPagamento, PedidoVenda pedidoVenda, Empresa empresa) {
		this.numero = numero;
		this.serie = serie;
		this.chaveDeAcesso = chaveDeAcesso;
		this.dataEmissao = dataEmissao;
		this.dataEntradaSaida = dataEntradaSaida;
		this.condPagamento = condPagamento;
		this.pedidoVenda = pedidoVenda;
		this.empresa = empresa;
	}

	public NotaFiscal() {
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public long getChaveDeAcesso() {
		return chaveDeAcesso;
	}

	public void setChaveDeAcesso(long chaveDeAcesso) {
		this.chaveDeAcesso = chaveDeAcesso;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataEntradaSaida() {
		return dataEntradaSaida;
	}

	public void setDataEntradaSaida(Date dataEntradaSaida) {
		this.dataEntradaSaida = dataEntradaSaida;
	}

	public CondicaoPagamento getCondPagamento() {
		return condPagamento;
	}

	public void setCondPagamento(CondicaoPagamento condPagamento) {
		this.condPagamento = condPagamento;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
