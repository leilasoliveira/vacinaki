package br.com.softwareit.vacinaki.models.pks;

import java.io.Serializable;

import br.com.softwareit.vacinaki.models.Usuario;
import br.com.softwareit.vacinaki.models.Vacina;

public class DoseVacinaId implements Serializable {

	public Usuario usuario;
	public Vacina vacina;
	
}
