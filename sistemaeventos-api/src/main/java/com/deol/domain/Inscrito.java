package com.deol.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscrito")
public class Inscrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_cracha", length = 80, nullable = false)
	private String nomeCracha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "id.inscrito")
	private Set<InscritoAtividade> inscritoAtividades = new HashSet<>();

	public Inscrito() {
	}

	public Inscrito(Long id, String nomeCracha, Date dataCadastro, Evento evento, Usuario usuario) {
		super();
		this.id = id;
		this.nomeCracha = nomeCracha;
		this.dataCadastro = dataCadastro;
		this.evento = evento;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCracha() {
		return nomeCracha;
	}

	public void setNomeCracha(String nomeCracha) {
		this.nomeCracha = nomeCracha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<InscritoAtividade> getInscritoAtividades() {
		return inscritoAtividades;
	}

	public void setInscritoAtividades(Set<InscritoAtividade> inscritoAtividades) {
		this.inscritoAtividades = inscritoAtividades;
	}
	
	public List<Atividade> getAtividades(){
		List<Atividade> atividades = new ArrayList<Atividade>();
		for(InscritoAtividade o : inscritoAtividades) {
			atividades.add(o.getAtividade());
		}
		return atividades;
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
		Inscrito other = (Inscrito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
