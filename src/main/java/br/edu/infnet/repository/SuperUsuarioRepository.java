package br.edu.infnet.repository;

import br.edu.infnet.model.SuperUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperUsuarioRepository extends CrudRepository<SuperUsuario, Long> {

    SuperUsuario findByUsernameOrEmail(String username, String email);
}
