package br.com.vsetsistemas.model;

import java.util.Date;

public class Pagamento {

	private int id;
	private Date dataVencimento;
	private Date dataPagamento;
	private String status;
	private CondicaoPagamento condPagamento;
	private int numeroParcela;
	
	public Pagamento(int id, Date dataVencimento, Date dataPagamento, String status, CondicaoPagamento condPagamento,
			int numeroParcela) {
		super();
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.status = status;
		this.condPagamento = condPagamento;
		this.numeroParcela = numeroParcela;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CondicaoPagamento getCondPagamento() {
		return condPagamento;
	}

	public void setCondPagamento(CondicaoPagamento condPagamento) {
		this.condPagamento = condPagamento;
	}

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	

	
	
}
