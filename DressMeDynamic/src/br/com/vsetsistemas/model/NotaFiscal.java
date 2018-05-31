package br.com.vsetsistemas.model;

import java.util.Date;

public class NotaFiscal {

	private long numero;
	private int serie;
	private long chaveDeAcesso;
	private Date dataEmissao;
	private Date dataEntradaSaida;
	private Date horaSaida;
	private CondicaoPagamento condPagamento;
	private PedidoVenda pedidoVenda;
	private Empresa empresa;
	private boolean status;
	
	public NotaFiscal(long numero, int serie, long chaveDeAcesso, Date dataEmissao, Date dataEntradaSaida,
			Date horaSaida, CondicaoPagamento condPagamento, PedidoVenda pedidoVenda, Empresa empresa, boolean status) {
		this.numero = numero;
		this.serie = serie;
		this.chaveDeAcesso = chaveDeAcesso;
		this.dataEmissao = dataEmissao;
		this.dataEntradaSaida = dataEntradaSaida;
		this.horaSaida = horaSaida;
		this.condPagamento = condPagamento;
		this.pedidoVenda = pedidoVenda;
		this.empresa = empresa;
		this.status = status;
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

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
