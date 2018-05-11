package br.com.vsetsistemas.model;

import java.sql.Date;

public class Cliente extends Pessoa {

	private long cpf;
	private Date dataNascimento;
	private long rg;
	private long inscricaoEstadual;
	private String telefoneCelular;
	private String telefoneResidencial;
	private String telefoneComercial;

	public Cliente(long id, String nome, int numero, String complemento, long cep, String cidade,
			String email, long cpf, Date dataNascimento, long rg, long inscricaoEstadual,
			String telefoneCelular, String telefoneResidencial, String telefoneComercial, Boolean status) {

		super(id, nome, numero, complemento, cep, cidade, email, status);

		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.inscricaoEstadual = inscricaoEstadual;
		this.telefoneCelular = telefoneCelular;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneComercial = telefoneComercial;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

}
