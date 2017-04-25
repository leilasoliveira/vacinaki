package br.com.softwareit.vacinaki.models;

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
	public Integer id;
	
	public String nome;
	
	public String descricao;
	
	public String observacoes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Epoca epocaInicial; /* idade recomendada */
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Epoca epocaFinal; /* idade recomendada */

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

	public Epoca getEpocaInicial() {
		return epocaInicial;
	}

	public void setEpocaInicial(Epoca epocaInicial) {
		this.epocaInicial = epocaInicial;
	}

	public Epoca getEpocaFinal() {
		return epocaFinal;
	}

	public void setEpocaFinal(Epoca epocaFinal) {
		this.epocaFinal = epocaFinal;
	}
	
	
}
