package br.com.softwareit.vacinaki.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.PaginatedList;
import br.com.softwareit.vacinaki.models.Vacina;

@Repository
public class VacinaDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Vacina> all() {
		return manager.createQuery("select v from Vacina v", Vacina.class)
				.getResultList();
	}

	public void save(Vacina vacina) {
		manager.persist(vacina);
	}

	public Vacina findById(Integer id) {
		return manager.find(Vacina.class, id);
	}

	public void remove(Vacina vacina) {
		manager.remove(vacina);
	}

	public void update(Vacina vacina) {
		manager.merge(vacina);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Vacina.class, page,
				max);
	}

}
