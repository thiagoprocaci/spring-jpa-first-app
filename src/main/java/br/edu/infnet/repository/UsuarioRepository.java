package br.edu.infnet.repository;


import br.edu.infnet.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

     Long countByTipo(Integer tipo);

     Usuario findByUsernameOrEmail(String username, String email);

}
