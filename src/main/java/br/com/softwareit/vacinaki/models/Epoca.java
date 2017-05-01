package br.com.softwareit.vacinaki.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.softwareit.vacinaki.models.enuns.TempoEnum;

@Entity
public class Epoca implements Serializable {

	private static final long serialVersionUID = -9030950373532995021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Integer valorInicial;
	
	private Integer valorLimite;
	
	@Enumerated(EnumType.STRING)
	private TempoEnum unidadeTempoInicial;
	
	@Enumerated(EnumType.STRING)
	private TempoEnum unidadeTempoLimite;
	
	private Integer ordem;

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

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	
}
