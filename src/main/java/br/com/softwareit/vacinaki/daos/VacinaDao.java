package br.com.softwareit.vacinaki.daos;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.Vacina;

@Repository
public interface VacinaDao extends CrudRepository<Vacina, Integer> {
	
	@Query("select v from Vacina v join v.epoca e")
	@OrderBy("v.nome, e.ordem")
	public List<Vacina> all();

}
