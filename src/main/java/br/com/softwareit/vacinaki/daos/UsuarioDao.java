package br.com.softwareit.vacinaki.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.PaginatedList;
import br.com.softwareit.vacinaki.models.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Usuario> all() {
		return manager.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}

	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario findById(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Usuario.class, page,
				max);
	}

}
