package br.com.softwareit.vacinaki.daos;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.Epoca;

@Repository
public interface EpocaDao extends CrudRepository<Epoca, Integer>{

	@Query("select e from Epoca e")
	@OrderBy("ordem")
	public List<Epoca> all();

}
