package br.com.softwareit.vacinaki.models.enuns;

public enum TempoEnum {

	MES("Mês"),
	ANO("Ano"),
	GRAVIDEZ("Gravidez");
	
	private String nome;
	
	private TempoEnum(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
