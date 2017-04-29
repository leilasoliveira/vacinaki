package br.com.softwareit.vacinaki.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private String observacoes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Epoca epoca; /* idade recomendada */
	
	@Column(name = "epoca_id", insertable = false, updatable = false)
	private Integer idEpoca;
	
	private Integer doses;

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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Epoca getEpoca() {
		return epoca;
	}

	public void setEpoca(Epoca epoca) {
		this.epoca = epoca;
	}

	public Integer getIdEpoca() {
		return idEpoca;
	}

	public void setIdEpoca(Integer idEpoca) {
		this.idEpoca = idEpoca;
	}

	public Integer getDoses() {
		return doses;
	}

	public void setDoses(Integer doses) {
		this.doses = doses;
	}

}
