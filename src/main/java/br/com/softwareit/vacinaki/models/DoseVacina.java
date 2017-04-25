package br.com.softwareit.vacinaki.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.softwareit.vacinaki.models.pks.DoseVacinaId;

@Entity
@IdClass(DoseVacinaId.class)
public class DoseVacina {
	
	@Id
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Id
	@OneToOne
	@JoinColumn(name = "vacina_id")
	private Vacina vacina;
	
	private LocalDate dataVacinacao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

}
