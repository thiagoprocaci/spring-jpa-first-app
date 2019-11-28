package br.edu.infnet.repository;

import br.edu.infnet.model.UsuarioComum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioComumRepository extends CrudRepository<UsuarioComum, Long> {

    List<UsuarioComum> findByEndereco(String endereco);
}
