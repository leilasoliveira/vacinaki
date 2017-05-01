package br.com.softwareit.vacinaki.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.softwareit.vacinaki.models.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
