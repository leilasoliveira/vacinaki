package br.com.softwareit.vacinaki.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.Epoca;
import br.com.softwareit.vacinaki.models.PaginatedList;

@Repository
public class EpocaDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Epoca> all() {
		return manager.createQuery("select e from Epoca e", Epoca.class)
				.getResultList();
	}

	public void save(Epoca epoca) {
		manager.persist(epoca);
	}

	public Epoca findById(Integer id) {
		return manager.find(Epoca.class, id);
	}

	public void remove(Epoca epoca) {
		manager.remove(epoca);
	}

	public void update(Epoca epoca) {
		manager.merge(epoca);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Epoca.class, page,
				max);
	}

}
