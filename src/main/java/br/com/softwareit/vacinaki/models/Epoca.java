package br.com.softwareit.vacinaki.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.softwareit.vacinaki.models.enuns.TempoEnum;

@Entity
public class Epoca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public String nome;
	
	public Integer valorInicial;
	
	public Integer valorLimite;
	
	@Enumerated(EnumType.STRING)
	public TempoEnum unidadeTempoInicial;
	
	@Enumerated(EnumType.STRING)
	public TempoEnum unidadeTempoLimite;

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

	public Integer getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Integer valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Integer getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(Integer valorLimite) {
		this.valorLimite = valorLimite;
	}

	public TempoEnum getUnidadeTempoInicial() {
		return unidadeTempoInicial;
	}

	public void setUnidadeTempoInicial(TempoEnum unidadeTempoInicial) {
		this.unidadeTempoInicial = unidadeTempoInicial;
	}

	public TempoEnum getUnidadeTempoLimite() {
		return unidadeTempoLimite;
	}

	public void setUnidadeTempoLimite(TempoEnum unidadeTempoLimite) {
		this.unidadeTempoLimite = unidadeTempoLimite;
	}
}
