package com.deol.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.deol.domain.enums.TipoAtividade;

@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Lob
	@Column(nullable = true)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private TipoAtividade tipo;

	@Column(name = "qtde_max_part", nullable = true)
	private Integer quantidadeMaximaParticipantes;

	@Column(length = 100, nullable = true)
	private String local;

	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;

	@OneToMany(mappedBy = "atividade")
	private List<AtividadeHorario> horarios = new ArrayList<AtividadeHorario>();

	@OneToMany(mappedBy = "id.atividade")
	private Set<InscritoAtividade> atividadeInscritos = new HashSet<>();

	public Atividade() {
	}

	public Atividade(Integer id, String nome, String descricao, TipoAtividade tipo,
			Integer quantidadeMaximaParticipantes, String local, Evento evento) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
		this.local = local;
		this.evento = evento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public TipoAtividade getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtividade tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantidadeMaximaParticipantes() {
		return quantidadeMaximaParticipantes;
	}

	public void setQuantidadeMaximaParticipantes(Integer quantidadeMaximaParticipantes) {
		this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<AtividadeHorario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<AtividadeHorario> horarios) {
		this.horarios = horarios;
	}

	public Set<InscritoAtividade> getAtividadeInscritos() {
		return atividadeInscritos;
	}

	public void setAtividadeInscritos(Set<InscritoAtividade> atividadeInscritos) {
		this.atividadeInscritos = atividadeInscritos;
	}
	
	public List<Inscrito> getInscritos(){
		List<Inscrito> inscritos = new ArrayList<>();
		for(InscritoAtividade o : atividadeInscritos) {
			inscritos.add(o.getInscrito());
		}
		return inscritos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
