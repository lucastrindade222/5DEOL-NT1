package com.deol.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 15, nullable = true)
	private String cep;

	@Column(length = 100, nullable = true)
	private String logradouro;

	@Column(length = 10, nullable = true)
	private String numero;

	@Column(length = 80, nullable = true)
	private String bairro;

	@Column(length = 80, nullable = true)
	private String cidade;

	@Column(length = 50, nullable = true)
	private String uf;

	@Column(length = 100, nullable = true)
	private String complemento;

	public Endereco() {
	}

	public Endereco(String cep, String logradouro, String numero, String bairro, String cidade, String uf,
			String complemento) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
