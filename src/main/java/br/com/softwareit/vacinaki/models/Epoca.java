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
	
	public Integer valor;
	
	@Enumerated(EnumType.STRING)
	public TempoEnum unidadeTempo;

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

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public TempoEnum getUnidadeTempo() {
		return unidadeTempo;
	}

	public void setUnidadeTempo(TempoEnum unidadeTempo) {
		this.unidadeTempo = unidadeTempo;
	}
	
	
}
