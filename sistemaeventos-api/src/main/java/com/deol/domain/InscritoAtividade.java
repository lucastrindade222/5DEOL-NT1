package com.deol.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inscrito_atividade")
public class InscritoAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InscritoAtividadePK id = new InscritoAtividadePK();
	
	@Column(nullable = false)
	private Boolean presenca;

	public InscritoAtividade() {
	}

	public InscritoAtividade(Inscrito inscrito, Atividade atividade, Boolean presenca) {
		super();
		id.setInscrito(inscrito);
		id.setAtividade(atividade);
		this.presenca = presenca;
	}
	
	public Inscrito getInscrito() {
		return id.getInscrito();
	}
	
	public void setInscrito(Inscrito inscrito) {
		id.setInscrito(inscrito);
	}
	
	public Atividade getAtividade() {
		return id.getAtividade();
	}
	
	public void setAtividade(Atividade atividade) {
		id.setAtividade(atividade);
	}

	public InscritoAtividadePK getId() {
		return id;
	}

	public void setId(InscritoAtividadePK id) {
		this.id = id;
	}

	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}

}
